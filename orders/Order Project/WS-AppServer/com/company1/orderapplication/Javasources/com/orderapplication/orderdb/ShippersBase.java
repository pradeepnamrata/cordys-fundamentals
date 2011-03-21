/*
  This class has been generated by the Code Generator
*/

package com.orderdb;

import com.cordys.cpc.bsf.busobject.BusObjectConfig;
import com.cordys.cpc.bsf.busobject.BusObjectIterator;
import com.cordys.cpc.bsf.busobject.QueryObject;
import com.cordys.cpc.bsf.classinfo.AttributeInfo;
import com.cordys.cpc.bsf.classinfo.ClassInfo;
import com.cordys.cpc.bsf.classinfo.RelationInfo_FK;
import com.cordys.cpc.bsf.listeners.constraint.NumberValidator;
import com.cordys.cpc.bsf.listeners.constraint.StringValidator;


public abstract class ShippersBase extends com.cordys.cpc.bsf.busobject.StateBusObject
{
    // tags used in the XML document
    public final static String ATTR_ShipperID = "ShipperID";
    public final static String ATTR_CompanyName = "CompanyName";
    public final static String ATTR_Phone = "Phone";
    private final static String REL_OrdersObjects = "FK:Shippers[ShipperID]:Orders[ShipVia]";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(Shippers.class);
            s_classInfo.setTableName("Shippers");
            s_classInfo.setUIDElements(new String[]{ATTR_ShipperID});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_ShipperID);
                ai.setJavaName("ShipperID");
                ai.setColumnName("ShipperID");
                ai.setAttributeClass(int.class);
                NumberValidator v = new NumberValidator(ATTR_ShipperID);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_CompanyName);
                ai.setJavaName("CompanyName");
                ai.setColumnName("CompanyName");
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_CompanyName);
                v.setMaxLength(40);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_Phone);
                ai.setJavaName("Phone");
                ai.setColumnName("Phone");
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_Phone);
                v.setMaxLength(24);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                // relation OrdersObjects (FK:Shippers[ShipperID]:Orders[ShipVia])
                RelationInfo_FK ri = new RelationInfo_FK(REL_OrdersObjects);
                ri.setName("OrdersObjects");
                ri.setLocalAttributes(new String[]{"ShipperID"});
                ri.setLocalIsPK(true);
                ri.setRelatedClass(com.orderdb.Orders.class);
                ri.setRelatedAttributes(new String[]{"ShipVia"});
                ri.setRelatedIdentifier("FK:Orders[ShipVia]:Shippers[ShipperID]");
                ri.setLoadMethod("loadOrdersObjects");
                s_classInfo.addRelationInfo(ri);
            }
        }
        return s_classInfo;
    }

    public ShippersBase(BusObjectConfig config)
    {
        super(config);
    }

    public int getShipperID()
    {
        return getIntProperty(ATTR_ShipperID);
    }

    public void setShipperID(int value)
    {
        setProperty(ATTR_ShipperID, value, 0);
    }

    public String getCompanyName()
    {
        return getStringProperty(ATTR_CompanyName);
    }

    public void setCompanyName(String value)
    {
        setProperty(ATTR_CompanyName, value, 0);
    }

    public String getPhone()
    {
        return getStringProperty(ATTR_Phone);
    }

    public void setPhone(String value)
    {
        setProperty(ATTR_Phone, value, 0);
    }

    public BusObjectIterator<Orders> getOrdersObjects()
    {
        return getMultiRelationObjects(REL_OrdersObjects);
    }
    public BusObjectIterator<Orders> loadOrdersObjects()
    {
        String queryText = "select * from \"Orders\" where \"ShipVia\" = :ShipperID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("ShipperID", "Orders.ShipVia", QueryObject.PARAM_INT, new Integer(getShipperID()));
        query.setResultClass(Orders.class);
        return query.getObjects();
    }


    public void addOrdersObject(Orders a_Orders)
    {
        a_Orders.setShipVia(this.getShipperID());
    }

    public void removeOrdersObject(Orders a_Orders)
    {
        a_Orders.setNull("ShipVia");
    }

    public static BusObjectIterator<com.orderdb.Shippers> getNextShippersObjects(int ShipperID, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"Shippers\" where (\"ShipperID\" > :ShipperID) order by \"ShipperID\" asc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("ShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(ShipperID));
        query.setResultClass(Shippers.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.orderdb.Shippers> getPreviousShippersObjects(int ShipperID, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"Shippers\" where (\"ShipperID\" < :ShipperID) order by \"ShipperID\" desc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("ShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(ShipperID));
        query.setResultClass(Shippers.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static com.orderdb.Shippers getShippersObject(int ShipperID)
    {
        String queryText = "select * from \"Shippers\" where \"ShipperID\" = :ShipperID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("ShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(ShipperID));
        query.setResultClass(Shippers.class);
        return (Shippers)query.getObject();
    }

    public static BusObjectIterator<com.orderdb.Shippers> getShippersObjects(int fromShipperID, int toShipperID, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"Shippers\" where \"ShipperID\" between :fromShipperID and :toShipperID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(fromShipperID));
        query.addParameter("toShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(toShipperID));
        query.setResultClass(Shippers.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.orderdb.Shippers> getShippersObjects(int fromShipperID, int toShipperID)
    {
        String queryText = "select * from \"Shippers\" where \"ShipperID\" between :fromShipperID and :toShipperID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(fromShipperID));
        query.addParameter("toShipperID", "Shippers.ShipperID", QueryObject.PARAM_INT, new Integer(toShipperID));
        query.setResultClass(Shippers.class);
        return query.getObjects();
    }

}
