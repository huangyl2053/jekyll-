/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.core.dbd492001;

import jp.co.ndensan.reams.db.dbd.entity.db.relate.dbd492001.ichijiteburu.FairudetaIchijiTeburuEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4003YokaigoNinteiInterfaceEntity;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定インターフェースマスタの編集ビジネスクラスです。
 *
 * @reamsid_L DBD-1510-030 x_xuliang
 */
public class YokaigoninteiIntafesebusiness {

    /**
     * 要介護認定インターフェースマスタをセット
     *
     * @param f JinbunoQurirumirisutofairuYishiteburuEntity
     * @param entity DbT4003YokaigoNinteiInterfaceEntity
     */
    public void editDbT4003Yokaigo(FairudetaIchijiTeburuEntity f, DbT4003YokaigoNinteiInterfaceEntity entity) {
        entity.setShinseishoKanriNo(new ShinseishoKanriNo(f.getShinseishoKanriNo()));
        entity.setHihokenshaNo(new HihokenshaNo(f.getHihokenjabango()));
        entity.setRirekiNo(new RString("0000"));
        entity.setTorikomiTimestamp(YMDHMS.now());
        entity.setTorikomiKubun(new RString("0"));
        if (f.getShinseikubunshinseiji() != null) {
            entity.setShinseiShubetsuCode(f.getShinseikubunshinseiji().value());
        } else {
            entity.setShinseiShubetsuCode(RString.EMPTY);
        }
        if (f.getTorisakubunkodo() != null) {
            entity.setTorisageKubunCode(f.getTorisakubunkodo().value());
        } else {
            entity.setTorisageKubunCode(RString.EMPTY);
        }
        entity.setShinseiYMD(f.getNinteishinseibi());
        entity.setIryoKikanCode(f.getShujiiiryokikanbango());
        entity.setShujiiCode(f.getShujiibango());
        entity.setIkenshoIraiYMD(f.getLkenshoiraibi());
        entity.setIkenshoToriyoseYMD(f.getLkenshonyushubi());
        entity.setChosaItakuYMD(f.getChosairaibi());
        entity.setChosaShuryoYMD(f.getChosajisshibi());
        entity.setChosaItakusakiCode(new JigyoshaNo(f.getLtakukubun()));
        entity.setChosainCode(f.getNinteichosainbango());
        entity.setIchijiHanteiYMD(f.getLchijihanteibi());
        entity.setIchijiHanteiKekkaCode(f.getLchijihanteikekka());
        entity.setIchijiHanteiKekkaKasanCode(RString.EMPTY);
        entity.setShinsakaiShiryoSakuseiYMD(f.getNinteishinsakaishiryosakuseibi());
        entity.setShinsakaiYoteiYMD(f.getNinteishinsakaiyoteibi());
        if (f.getGogitaibango() != null) {
            entity.setGogitaiNo(Integer.parseInt(f.getGogitaibango().toString()));
        }
        entity.setNijiHanteiYMD(f.getNijihanteibi());
        entity.setNijiHanteiKekkaCode(f.getNijihanteikekka());
        entity.setNinteiYukoKikanStart(f.getNinteiyukokigen_kaishi());
        entity.setNinteiYukoKikanEnd(f.getNinteiyukokigen_shuryo());

        if (f.getGenzainosabisukubunkodo() != null) {
            entity.setServiceHenkoRiyuCode(f.getGenzainosabisukubunkodo().value());
        } else {
            entity.setServiceHenkoRiyuCode(RString.EMPTY);
        }
        if (f.getTokuteishippeikodo() != null) {
            entity.setTokuteiShippeiCode(f.getTokuteishippeikodo().value());
        } else {
            entity.setTokuteiShippeiCode(RString.EMPTY);
        }
        entity.setShogaiKoreiJiritsudo(f.getShogaikoreishajiritsudo());
        entity.setNinchishoKoreiJiritsudo(f.getNinshishokoreishajiritsudo());
        entity.setShinsakaiIken(f.getNinteishinsakaiikento());
        entity.setVersionNo(f.getShikibetsukodo());
        entity.setIchijiHanteiNaiyo(f.getYokaigoninteitokijunjikan().concat(new RString("～").concat(f.getNinchikinokyufukubun())));
        entity.setIchijiHanteiNaiyo2(RString.EMPTY);
        entity.setZenTorikomiTimestamp(null);
        entity.setKeshikomiFlag(RString.EMPTY);
        entity.setKeshikomiTimestamp(null);
        entity.setYobiKomoku1(RString.EMPTY);
        entity.setYobiKomoku2(RString.EMPTY);
        entity.setYobiKomoku3(RString.EMPTY);
        entity.setYobiKomoku4(RString.EMPTY);
        entity.setYobiKomoku5(RString.EMPTY);
        entity.setYobiKubun1(RString.EMPTY);
        entity.setYobiKubun2(RString.EMPTY);
        entity.setYobiKubun3(RString.EMPTY);
        entity.setYobiKubun4(RString.EMPTY);
        entity.setYobiKubun5(RString.EMPTY);
        entity.setReserve(RString.EMPTY);
    }
}
