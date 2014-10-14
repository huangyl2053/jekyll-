/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.persistence.basic;

import jp.co.ndensan.reams.db.dbb.entity.basic.DbT2010FukaErrorListEntity;
import jp.co.ndensan.reams.db.dbb.persistence.basic.testhelper.FukaErrorListInserter;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.KaigoHihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.TsuchishoNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbbTestBase;
import jp.co.ndensan.reams.ur.urz.definition.enumeratedtype.InternalReportShoriKubun;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 賦課エラー一覧の情報を取得するDacのテストです。
 *
 * @author n8178 城間篤人
 */
@RunWith(Enclosed.class)
public class FukaErrorListData {

    private static FukaErrorListDac sut;
    private static FukaErrorListInserter inserter;

    @BeforeClass
    public static void setUpBeforeClass() {
        sut = InstanceProvider.create(FukaErrorListDac.class);
        inserter = InstanceProvider.create(FukaErrorListInserter.class);
    }

    public static class testData extends DbbTestBase {

        @Test
        public void createTestDate() {
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "01"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "02"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "03"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "04"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "05"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "06"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "07"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "08"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "09"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "10"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "11"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "12"));
            inserter.insert(createEntity(RDateTime.of(2002, 12, 31, 12, 12, 12), "13"));

            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "01"));
            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "02"));
            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "03"));
            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "04"));
            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "05"));
            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "06"));
            inserter.insert(createEntity(RDateTime.of(2003, 7, 7, 11, 6, 45), "07"));

            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "01"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "02"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "03"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "04"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "05"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "06"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "07"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "08"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "09"));
            inserter.insert(createEntity(RDateTime.of(2004, 2, 22, 22, 22, 22), "10"));

            inserter.insert(createEntity(RDateTime.of(2005, 1, 14, 2, 34, 11), "01"));
            inserter.insert(createEntity(RDateTime.of(2005, 1, 14, 2, 34, 11), "02"));
            inserter.insert(createEntity(RDateTime.of(2005, 1, 14, 2, 34, 11), "03"));

            inserter.insert(createEntity(RDateTime.of(2006, 5, 2, 5, 1, 4), "01"));

            inserter.insert(createEntity(RDateTime.of(2007, 12, 4, 0, 56, 19), "01"));
            inserter.insert(createEntity(RDateTime.of(2007, 12, 4, 0, 56, 19), "02"));
            inserter.insert(createEntity(RDateTime.of(2007, 12, 4, 0, 56, 19), "03"));
            inserter.insert(createEntity(RDateTime.of(2007, 12, 4, 0, 56, 19), "04"));
            inserter.insert(createEntity(RDateTime.of(2007, 12, 4, 0, 56, 19), "05"));
            inserter.insert(createEntity(RDateTime.of(2007, 12, 4, 0, 56, 19), "06"));

            inserter.insert(createEntity(RDateTime.of(2008, 1, 1, 12, 7, 45), "01"));
            inserter.insert(createEntity(RDateTime.of(2008, 1, 1, 12, 7, 45), "02"));
            inserter.insert(createEntity(RDateTime.of(2008, 1, 1, 12, 7, 45), "03"));
            inserter.insert(createEntity(RDateTime.of(2008, 1, 1, 12, 7, 45), "04"));
            inserter.insert(createEntity(RDateTime.of(2008, 1, 1, 12, 7, 45), "05"));

            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "01"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "02"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "03"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "04"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "05"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "06"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "07"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "08"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "09"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "10"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "11"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "12"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "13"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "14"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "15"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "16"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "17"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "18"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "19"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "20"));
            inserter.insert(createEntity(RDateTime.of(2009, 2, 3, 7, 23, 2), "21"));

            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "01"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "02"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "03"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "04"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "05"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "06"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "07"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "08"));
            inserter.insert(createEntity(RDateTime.of(2010, 2, 21, 23, 1, 56), "09"));

            inserter.insert(createEntity(RDateTime.of(2011, 3, 5, 2, 12, 34), "01"));
            inserter.insert(createEntity(RDateTime.of(2011, 3, 5, 2, 12, 34), "02"));

            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "01"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "02"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "03"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "04"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "05"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "06"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "07"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "08"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "09"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "10"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "11"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "12"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "13"));
            inserter.insert(createEntity(RDateTime.of(2012, 4, 1, 11, 11, 11), "14"));

            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "01"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "02"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "03"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "04"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "05"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "06"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "07"));
            inserter.insert(createEntity(RDateTime.of(2013, 5, 10, 2, 6, 54), "08"));

            inserter.insert(createEntity(RDateTime.of(2014, 6, 13, 13, 31, 13), "01"));
            inserter.insert(createEntity(RDateTime.of(2014, 6, 13, 13, 31, 13), "02"));
            inserter.insert(createEntity(RDateTime.of(2014, 6, 13, 13, 31, 13), "03"));
            inserter.insert(createEntity(RDateTime.of(2014, 6, 13, 13, 31, 13), "04"));
            inserter.insert(createEntity(RDateTime.of(2014, 6, 13, 13, 31, 13), "05"));
        }
    }

    private static DbT2010FukaErrorListEntity createEntity(RDateTime listCreatringDateTime, String tsuchishoNo) {
        DbT2010FukaErrorListEntity entity = new DbT2010FukaErrorListEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setInternalReportId(new RString("FukaErrorList"));
        entity.setInternalReportCreationDateTime(listCreatringDateTime);
        entity.setBatchId(new RString("0001"));
        entity.setBatchStartingDateTime(listCreatringDateTime.minusDays(1).plusHours(1));
        entity.setFukaNendo(new FlexibleYear(listCreatringDateTime.getDate().getYear().toDateString()));
        entity.setTsuchishoNo(new TsuchishoNo(new RString("12345678901234" + tsuchishoNo)));
        entity.setErrorCode(new Code("01"));
        entity.setHihokenshaNo(new KaigoHihokenshaNo(new RString("1234500001")));
        entity.setShikibetsuCode(new ShikibetsuCode("012345678900002"));
        entity.setShoriKubunCode(InternalReportShoriKubun.未処理.getCode());
        return entity;
    }

    private static DbT2010FukaErrorListEntity createEntity(RDateTime listCreatringDateTime, String tsuchishoNo, FlexibleYear fukaNendo) {
        DbT2010FukaErrorListEntity entity = createEntity(listCreatringDateTime, tsuchishoNo);
        entity.setFukaNendo(new FlexibleYear(fukaNendo.toDateString()));
        return entity;
    }

}
