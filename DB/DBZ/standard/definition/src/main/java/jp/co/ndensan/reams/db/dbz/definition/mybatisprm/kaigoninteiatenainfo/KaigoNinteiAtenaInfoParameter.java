/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.mybatisprm.kaigoninteiatenainfo;

import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * 介護認定宛名情報のMyBatis用パラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@lombok.Getter
public class KaigoNinteiAtenaInfoParameter {

    private final boolean 識別コードフラグ;
    private final RString 識別コード;
    private final boolean 申請書管理番号フラグ;
    private final RString 申請書管理番号;
//    private final ShinseishoKanriNo shinseishoKanriNo;
//    private final ShikibetsuCode shikibetsuCode;
    private final RString psmShikibetsuTaisho;

    private KaigoNinteiAtenaInfoParameter(boolean 識別コードフラグ,
            RString 識別コード,
            boolean 申請書管理番号フラグ,
            RString 申請書管理番号,
            RString psmShikibetsuTaisho) {
        this.識別コードフラグ = 識別コードフラグ;
        this.識別コード = 識別コード;
        this.申請書管理番号フラグ = 申請書管理番号フラグ;
        this.申請書管理番号 = 申請書管理番号;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
    }

    public static KaigoNinteiAtenaInfoParameter createSelectByKeyParam(
            RString 識別コード,
            RString 申請書管理番号) {
        boolean 識別コードフラグ = false;
        boolean 申請書管理番号フラグ = false;
        if (!RString.isNullOrEmpty(識別コード)) {
            識別コードフラグ = true;
        }
        if (!RString.isNullOrEmpty(申請書管理番号)) {
            申請書管理番号フラグ = true;
        }

        // 宛名識別対象PSM
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.未定義
                ), true);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString();
        //super.sqlParameter.putAll(uaFt200Psm.getParameterMap());
        return new KaigoNinteiAtenaInfoParameter(識別コードフラグ,
                識別コード,
                申請書管理番号フラグ,
                申請書管理番号,
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()));
    }
}
