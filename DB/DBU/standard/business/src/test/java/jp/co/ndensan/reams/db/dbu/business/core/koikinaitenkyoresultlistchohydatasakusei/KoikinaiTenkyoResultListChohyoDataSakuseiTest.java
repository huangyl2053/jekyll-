/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlistchohydatasakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.koikinaitenkyoresultlist.KoikinaiTenkyoResultListChohyoDataSakusei;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoListEntity;
import jp.co.ndensan.reams.db.dbu.entity.kouikitenkyoresultlist.KoikinaiTenkyoResultEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.testhelper.DbuTestBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author quxiaodong
 */
public class KoikinaiTenkyoResultListChohyoDataSakuseiTest extends DbuTestBase {

    private static KoikinaiTenkyoListEntity entity;

    @Before
    public void setUp() {
        entity = new KoikinaiTenkyoListEntity();
        List<KoikinaiTenkyoEntity> list = new ArrayList<>();
        KoikinaiTenkyoEntity entity1 = new KoikinaiTenkyoEntity();
        entity1.set印刷日時(new FlexibleDate("20160114"));
        entity1.set被保険者番号(new HihokenshaNo("123456"));
        entity1.set氏名カナ(new AtenaKanaMeisho("カナ"));
        entity1.set氏名(new AtenaMeisho("qqq"));
        entity1.set旧住民コード(new ShikibetsuCode("1000"));
        entity1.set前住所(new RString("qqq"));
        entity1.set転出予定日(new FlexibleDate("19890108"));
        entity1.set転出確定日(new FlexibleDate("20160114"));
        entity1.set転出確定通知日(new FlexibleDate("20160114"));
        entity1.set処理日(new FlexibleDate("20160114"));
        entity1.set新住民コード(new ShikibetsuCode("1222"));
        entity1.set現住所(new RString("qqq"));
        entity1.set登録異動日(new FlexibleDate("20160114"));
        entity1.set登録届出日(new FlexibleDate("20160114"));
        entity1.set異動情報(new RString("qqq"));

        list.add(entity1);
        entity.set市町村コード(new LasdecCode("123232"));
        entity.set市町村名(new RString("カナ"));
        entity.setEntity(list);
    }

    @Test
    public void getKoikinaiTenkyoResultListChohyoData() {
        KoikinaiTenkyoResultListChohyoDataSakusei koki = new KoikinaiTenkyoResultListChohyoDataSakusei();
        List<KoikinaiTenkyoResultEntity> ceshi = koki.getKoikinaiTenkyoResultListChohyoData(entity);

    }

}
