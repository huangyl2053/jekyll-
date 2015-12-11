/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.kaigojuminhyo;

import jp.co.ndensan.reams.db.dbu.definition.batchprm.kaigojuminhyo.KaigoJuminhyoBatchParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.testhelper.DbaTestDacBase;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import static junit.framework.TestCase.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * バッチパラメータ作成のテストクラスです
 */
public class KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinderTest extends DbaTestDacBase {

    private static KaigoJuminhyoBatchParameter parameter;
    private static KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder sut;
    private static DbT7022ShoriDateKanriDac dac;

    public static final SubGyomuCode サブ業務コード = new SubGyomuCode("DBU");
    public static final RString 処理名 = new RString("介護住民票個別事項連携情報作成【他社住基】");
    public static final RString 処理枝番 = new RString("0000");

    @BeforeClass
    public static void test() {
        dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        parameter = new KaigoJuminhyoBatchParameter();
        sut = new KaigoJuminhyoKobetsuJikouBatchParameterSakuseiFinder(dac);
    }

    @Test
    public void 入力されたデータがある場合_編集結果を返して() {
        parameter = sut.getKaigoJuminhyoKobetsuJikouBatchParameter(new RString("20151212"), new RString("010101"));
        assertEquals(parameter.getTaishoKaishiYMDHMS().toString(), "20151212010101");
    }

    @Test
    public void 入力されたデータがない場合_NULLを返して() {
        parameter = sut.getKaigoJuminhyoKobetsuJikouBatchParameter(new RString(""), new RString(""));
        assertEquals(parameter.getTaishoKaishiYMDHMS().isEmpty(), true);
    }

    @Test
    public void 検索結果が存在する場合_対象開始日時を返して() {
        insert_DbT7022ShoriDateKanri(サブ業務コード, 処理名, 処理枝番);
        DbT7022ShoriDateKanriEntity result = sut.getChushutsukikanJoho();
        assertEquals(result.getTaishoKaishiYMD().toString(), "20100101");
    }

    @Test
    public void 検索結果が存在する場合_対象開始日時にNULLを返して() {
        insert_DbT7022ShoriDateKanriIsEmpty(サブ業務コード, 処理名, 処理枝番);
        DbT7022ShoriDateKanriEntity result = sut.getChushutsukikanJoho();
        assertEquals(result.getTaishoKaishiYMD() == null, true);
    }

    @Test
    public void 検索結果が存在しない場合_NULLを返して() {
        insert_DbT7022ShoriDateKanriNull(サブ業務コード, 処理名, 処理枝番);
        DbT7022ShoriDateKanriEntity result = sut.getChushutsukikanJoho();
        assertEquals(result == null, true);
    }

    private static void insert_DbT7022ShoriDateKanri(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番
    ) {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(サブ業務コード);
        entity.setShichosonCode(new LasdecCode("209007"));
        entity.setShoriName(処理名);
        entity.setShoriEdaban(処理枝番);
        entity.setNendo(new FlexibleYear("2015"));
        entity.setNendoNaiRenban(new RString("0000"));
        entity.setTaishoKaishiYMD(new FlexibleDate("20100101"));
        entity.setTaishoShuryoYMD(new FlexibleDate("20141212"));
        entity.setTaishoKaishiTimestamp(new YMDHMS("20100101121212"));
        entity.setTaishoShuryoTimestamp(new YMDHMS("20141212010101"));
        dac.save(entity);
    }

    private static void insert_DbT7022ShoriDateKanriIsEmpty(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番
    ) {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(サブ業務コード);
        entity.setShichosonCode(new LasdecCode("209007"));
        entity.setShoriName(処理名);
        entity.setShoriEdaban(処理枝番);
        entity.setNendo(new FlexibleYear("2015"));
        entity.setNendoNaiRenban(new RString("0000"));
        dac.save(entity);
    }

    private static void insert_DbT7022ShoriDateKanriNull(
            SubGyomuCode サブ業務コード,
            RString 処理名,
            RString 処理枝番
    ) {
        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(new SubGyomuCode("DBA"));
        entity.setShichosonCode(new LasdecCode("209007"));
        entity.setShoriName(処理名);
        entity.setShoriEdaban(処理枝番);
        entity.setNendo(new FlexibleYear("2015"));
        entity.setNendoNaiRenban(new RString("0000"));
        entity.setTaishoKaishiYMD(new FlexibleDate("20100101"));
        entity.setTaishoShuryoYMD(new FlexibleDate("20141212"));
        entity.setTaishoKaishiTimestamp(new YMDHMS("20100101121212"));
        entity.setTaishoShuryoTimestamp(new YMDHMS("20141212010101"));
        dac.save(entity);
    }
}
