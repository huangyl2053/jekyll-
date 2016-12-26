/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shinseijouhouinnsatu;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinseijouhouinnsatu.ShinseiJouhouInsatuMybatisParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinseimonitor.ShinseiMonitorEntity;
import jp.co.ndensan.reams.db.dbz.testhelper.DbeTestDacBase;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.Month;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 * {@link IShinseiJouhouInsatuRelateMapper} のテストクラス
 */
public class IShinseiJouhouInsatuRelateMapperTest extends DbeTestDacBase {

    private static IShinseiJouhouInsatuRelateMapper sut;

    @Before
    public void setUp() {
        sut = sqlSession.getMapper(IShinseiJouhouInsatuRelateMapper.class);
    }

    @Test
    public void 要介護認定調査督促状データ取得SQLにエラーがないこと() {
        List<ShinseiMonitorEntity> result = sut.selectShinseiJouhou(createPrm());
        System.out.println(result.size());
        assertTrue(true);
    }

    private ShinseiJouhouInsatuMybatisParameter createPrm() {
        RString 検索条件 = new RString("1");
        RDateTime 処理開始日時 = RDateTime.of(2015, Month.JANUARY, 1, 00, 00);
        RDateTime 処理終了日時 = RDateTime.of(2017, Month.DECEMBER, 1, 00, 00);
        FlexibleDate 申請日開始 = new FlexibleDate(2016, 10, 10);
        FlexibleDate 申請日終了 = new FlexibleDate(2016, 12, 31);
        boolean 作成条件User = false;
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登外優先));
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        RString shikibetsuTaisho = new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString());

        ShinseiJouhouInsatuMybatisParameter param = ShinseiJouhouInsatuMybatisParameter.creatParameter(
                検索条件, 処理開始日時, 処理終了日時, 申請日開始, 申請日終了, 作成条件User, shikibetsuTaisho);
        return param;
    }

}
