/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dbu.definition.mybatisprm.koikinaijushochitokurei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.ua.uax.business.core.psm.UaFt200FindShikibetsuTaishoFunction;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.ShikibetsuTaishoSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.KensakuYusenKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.shikibetsutaisho.psm.DataShutokuKubun;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 広域内住所地特例者一覧表のMyBatisパラメータクラスです。
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class KoikinaiJushochiTokureiMybatisparamter implements IMyBatisParameter{
    
    private static final RString 市町村DDL1件目コード = new RString("000000");
    private final RString shichosonCode;
    private final RString idoYMD;
    private final RString kaishibi;
    private final RString shuryobi;
    private final RString psmShikibetsuTaisho;
    private final boolean isEmptyShichosonCode;
    
    /**
     * コンストラクタ
     *
     * @param shichosonCode 市町村コード
     * @param idoYMD 基準日
     * @param kaishibi 今回開始日
     * @param shuryobi 今回終了日
     * @param psmShikibetsuTaisho 宛名識別対象PSM
     * @param isEmptyShichosonCode 市町村コードFlag
     */
    public KoikinaiJushochiTokureiMybatisparamter(RString shichosonCode,
            RString idoYMD,
            RString kaishibi,
            RString shuryobi,
            RString psmShikibetsuTaisho,
            boolean isEmptyShichosonCode) {
        this.shichosonCode = shichosonCode;
        this.idoYMD = idoYMD;
        this.kaishibi = kaishibi;
        this.shuryobi = shuryobi;
        this.psmShikibetsuTaisho = psmShikibetsuTaisho;
        this.isEmptyShichosonCode = isEmptyShichosonCode;
    }
    
    public static KoikinaiJushochiTokureiMybatisparamter createParamter(RString shichosonCode,
            RString idoYMD,
            RString kaishibi,
            RString shuryob) {
        ShikibetsuTaishoSearchKeyBuilder key = new ShikibetsuTaishoSearchKeyBuilder(
                ShikibetsuTaishoGyomuHanteiKeyFactory.createInstance(GyomuCode.DB介護保険, KensakuYusenKubun.住登内優先), true);
        key.setデータ取得区分(DataShutokuKubun.直近レコード);
        List<JuminShubetsu> 住民種別 = new ArrayList<>();
        List<JuminJotai> 住民状態 = new ArrayList<>();
        住民種別.add(JuminShubetsu.住登外個人_外国人);
        住民種別.add(JuminShubetsu.住登外個人_日本人);
        住民種別.add(JuminShubetsu.日本人);
        住民種別.add(JuminShubetsu.外国人);
        住民状態.add(JuminJotai.住民);
        住民状態.add(JuminJotai.住登外);
        住民状態.add(JuminJotai.消除者);
        住民状態.add(JuminJotai.転出者);
        住民状態.add(JuminJotai.死亡者);
        key.set住民種別(住民種別);
        key.set住民状態(住民状態);
        UaFt200FindShikibetsuTaishoFunction uaFt200Psm = new UaFt200FindShikibetsuTaishoFunction(key.getPSM検索キー());
        boolean isEmptyShichosonCodeFlag = false;
        if (!市町村DDL1件目コード.equals(shichosonCode)) {
            isEmptyShichosonCodeFlag = true;
        }
        return new KoikinaiJushochiTokureiMybatisparamter(shichosonCode, idoYMD, kaishibi, shuryob,
                new RString(uaFt200Psm.getParameterMap().get("psmShikibetsuTaisho").toString()), isEmptyShichosonCodeFlag);
        
    }
}
