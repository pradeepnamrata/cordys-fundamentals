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


public abstract class TerritoriesBase extends com.cordys.cpc.bsf.busobject.StateBusObject
{
    // tags used in the XML document
    public final static String ATTR_TerritoryID = "TerritoryID";
    public final static String ATTR_TerritoryDescription = "TerritoryDescription";
    public final static String ATTR_RegionID = "RegionID";
    private final static String REL_EmployeeTerritoriesObjects = "FK:Territories[TerritoryID]:EmployeeTerritories[TerritoryID]";
    private final static String REL_RegionIDObject = "FK:Territories[RegionID]:Region[RegionID]";
    private static ClassInfo s_classInfo = null;
    public static ClassInfo _getClassInfo()//NOPMD framework ensures this is thread safe
    {
        if ( s_classInfo == null )//NOPMD
        {
            s_classInfo = newClassInfo(Territories.class);
            s_classInfo.setTableName("Territories");
            s_classInfo.setUIDElements(new String[]{ATTR_TerritoryID});
            {
                AttributeInfo ai = new AttributeInfo(ATTR_TerritoryID);
                ai.setJavaName("TerritoryID");
                ai.setColumnName("TerritoryID");
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_TerritoryID);
                v.setMaxLength(20);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_TerritoryDescription);
                ai.setJavaName("TerritoryDescription");
                ai.setColumnName("TerritoryDescription");
                ai.setAttributeClass(String.class);
                StringValidator v = new StringValidator(ATTR_TerritoryDescription);
                v.setMaxLength(50);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                AttributeInfo ai = new AttributeInfo(ATTR_RegionID);
                ai.setJavaName("RegionID");
                ai.setColumnName("RegionID");
                ai.setAttributeClass(int.class);
                NumberValidator v = new NumberValidator(ATTR_RegionID);
                ai.addConstraintHandler(v);
                s_classInfo.addAttributeInfo(ai);
            }
            {
                // relation EmployeeTerritoriesObjects (FK:Territories[TerritoryID]:EmployeeTerritories[TerritoryID])
                RelationInfo_FK ri = new RelationInfo_FK(REL_EmployeeTerritoriesObjects);
                ri.setName("EmployeeTerritoriesObjects");
                ri.setLocalAttributes(new String[]{"TerritoryID"});
                ri.setLocalIsPK(true);
                ri.setRelatedClass(com.orderdb.EmployeeTerritories.class);
                ri.setRelatedAttributes(new String[]{"TerritoryID"});
                ri.setRelatedIdentifier("FK:EmployeeTerritories[TerritoryID]:Territories[TerritoryID]");
                ri.setLoadMethod("loadEmployeeTerritoriesObjects");
                s_classInfo.addRelationInfo(ri);
            }
            {
                // relation RegionIDObject (FK:Territories[RegionID]:Region[RegionID])
                RelationInfo_FK ri = new RelationInfo_FK(REL_RegionIDObject);
                ri.setName("RegionIDObject");
                ri.setLocalAttributes(new String[]{"RegionID"});
                ri.setLocalIsPK(false);
                ri.setRelatedClass(com.orderdb.Region.class);
                ri.setRelatedAttributes(new String[]{"RegionID"});
                ri.setRelatedIdentifier("FK:Region[RegionID]:Territories[RegionID]");
                ri.setLoadMethod("loadRegionIDObject");
                s_classInfo.addRelationInfo(ri);
            }
        }
        return s_classInfo;
    }

    public TerritoriesBase(BusObjectConfig config)
    {
        super(config);
    }

    public String getTerritoryID()
    {
        return getStringProperty(ATTR_TerritoryID);
    }

    public void setTerritoryID(String value)
    {
        setProperty(ATTR_TerritoryID, value, 0);
    }

    public String getTerritoryDescription()
    {
        return getStringProperty(ATTR_TerritoryDescription);
    }

    public void setTerritoryDescription(String value)
    {
        setProperty(ATTR_TerritoryDescription, value, 0);
    }

    public int getRegionID()
    {
        return getIntProperty(ATTR_RegionID);
    }

    public void setRegionID(int value)
    {
        String[] relations = new String[]{REL_RegionIDObject};
        this.updateSingleRelations(relations, false);
        setProperty(ATTR_RegionID, value, 0);
        this.updateSingleRelations(relations, true);
    }

    public BusObjectIterator<EmployeeTerritories> getEmployeeTerritoriesObjects()
    {
        return getMultiRelationObjects(REL_EmployeeTerritoriesObjects);
    }
    public BusObjectIterator<EmployeeTerritories> loadEmployeeTerritoriesObjects()
    {
        String queryText = "select * from \"EmployeeTerritories\" where \"TerritoryID\" = :TerritoryID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("TerritoryID", "EmployeeTerritories.TerritoryID", QueryObject.PARAM_STRING, getTerritoryID());
        query.setResultClass(EmployeeTerritories.class);
        return query.getObjects();
    }


    public void addEmployeeTerritoriesObject(EmployeeTerritories a_EmployeeTerritories)
    {
        a_EmployeeTerritories.setTerritoryID(this.getTerritoryID());
    }

    public void removeEmployeeTerritoriesObject(EmployeeTerritories a_EmployeeTerritories)
    {
        a_EmployeeTerritories.setNull("TerritoryID");
    }

    public Region getRegionIDObject()
    {
        return (Region)getSingleRelationObject(REL_RegionIDObject);
    }
    public Region loadRegionIDObject()
    {
        String queryText = "select * from \"Region\" where \"RegionID\" = :RegionID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("RegionID", "Region.RegionID", QueryObject.PARAM_INT, new Integer(getRegionID()));
        query.setResultClass(Region.class);
        return (Region)query.getObject();
    }


    public void setRegionIDObject(Region a_Region)
    {
        if (a_Region == null)
        {
            this.setNull("RegionID");
        }
        else
        {
            this.setRegionID(a_Region.getRegionID());
        }
    }

    public void setNull(String element)
    {
        super.setNull(element);
        if (ATTR_RegionID.equals(element))
        {
            this.updateSingleRelation(REL_RegionIDObject, false);
        }
    }
    public static BusObjectIterator<com.orderdb.Territories> getNextTerritoriesObjects(String TerritoryID, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"Territories\" where (\"TerritoryID\" > :TerritoryID) order by \"TerritoryID\" asc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("TerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, TerritoryID);
        query.setResultClass(Territories.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.orderdb.Territories> getPreviousTerritoriesObjects(String TerritoryID, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"Territories\" where (\"TerritoryID\" < :TerritoryID) order by \"TerritoryID\" desc";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("TerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, TerritoryID);
        query.setResultClass(Territories.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static com.orderdb.Territories getTerritoriesObject(String TerritoryID)
    {
        String queryText = "select * from \"Territories\" where \"TerritoryID\" = :TerritoryID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("TerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, TerritoryID);
        query.setResultClass(Territories.class);
        return (Territories)query.getObject();
    }

    public static BusObjectIterator<com.orderdb.Territories> getTerritoriesObjects(String fromTerritoryID, String toTerritoryID, com.cordys.cpc.bsf.query.Cursor cursor)
    {
        String queryText = "select * from \"Territories\" where \"TerritoryID\" between :fromTerritoryID and :toTerritoryID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromTerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, fromTerritoryID);
        query.addParameter("toTerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, toTerritoryID);
        query.setResultClass(Territories.class);
        query.setCursor(cursor);
        return query.getObjects();
    }

    public static BusObjectIterator<com.orderdb.Territories> getTerritoriesObjects(String fromTerritoryID, String toTerritoryID)
    {
        String queryText = "select * from \"Territories\" where \"TerritoryID\" between :fromTerritoryID and :toTerritoryID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("fromTerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, fromTerritoryID);
        query.addParameter("toTerritoryID", "Territories.TerritoryID", QueryObject.PARAM_STRING, toTerritoryID);
        query.setResultClass(Territories.class);
        return query.getObjects();
    }

    public static BusObjectIterator<com.orderdb.Territories> getTerritoriesObjectsForRegionID(int RegionID)
    {
        String queryText = "select * from \"Territories\" where \"RegionID\" = :RegionID";
        QueryObject query = new QueryObject(queryText);
        query.addParameter("RegionID", "Territories.RegionID", QueryObject.PARAM_INT, new Integer(RegionID));
        query.setResultClass(Territories.class);
        return query.getObjects();
    }

}
