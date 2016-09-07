/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.fuseigolist;

import jp.co.ndensan.reams.db.dba.definition.core.juminrendo.JuminRendoFuseigo;
import jp.co.ndensan.reams.db.dba.entity.euc.juminidorendoshikakutoroku.FuseigoListCsvEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbV1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuKaijoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuJutokuTekiyoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.HihokenshaKubunCode;
import jp.co.ndensan.reams.ua.uax.entity.db.basic.UaFt200FindShikibetsuTaishoEntity;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminShubetsu;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.idojiyu.JukiIdoJiyu;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;

/**
 * 不整合リストCSVファイルの編集です。
 *
 * @reamsid_L DBA-1410-011 yaodongsheng
 */
public class FuseigoListHenshu {

    /**
     * 不整合リストCSVファイルの編集です。
     *
     * @param 不整合コード 不整合コード
     * @param 被保険者台帳 被保険者台帳
     * @param 住民異動情報 住民異動情報
     * @return FuseigoListCsvEntity
     */
    public FuseigoListCsvEntity setEucCsvEntity(RString 不整合コード, DbV1001HihokenshaDaichoEntity 被保険者台帳,
            UaFt200FindShikibetsuTaishoEntity 住民異動情報) {
        FuseigoListCsvEntity eucCsvEntity = new FuseigoListCsvEntity();
        eucCsvEntity.set不整合コード(不整合コード);
        eucCsvEntity.set不整合内容(JuminRendoFuseigo.toValue(不整合コード).get名称());
        HihokenshaNo 被保険者番号 = 被保険者台帳.getHihokenshaNo();
        if (被保険者番号 != null) {
            eucCsvEntity.set被保険者番号(被保険者番号.value());
        }
        eucCsvEntity.set異動日(set年月日(被保険者台帳.getIdoYMD()));
        eucCsvEntity.set枝番(被保険者台帳.getEdaNo());
        eucCsvEntity.set被保険者台帳_異動事由コード(被保険者台帳.getIdoJiyuCode());
        eucCsvEntity.set被保険者台帳_異動事由(set被保険者台帳_異動事由(被保険者台帳.getIdoJiyuCode()));
        LasdecCode 市町村コード = 被保険者台帳.getShichosonCode();
        if (市町村コード != null) {
            eucCsvEntity.set市町村コード(市町村コード.value());
        }
        ShikibetsuCode 識別コード = 被保険者台帳.getShikibetsuCode();
        if (識別コード != null) {
            eucCsvEntity.set識別コード(識別コード.value());
        }
        eucCsvEntity.set資格取得事由コード(被保険者台帳.getShikakuShutokuJiyuCode());
        eucCsvEntity.set資格取得事由(ShikakuShutokuJiyu.toValue(被保険者台帳.getShikakuShutokuJiyuCode()).get名称());
        eucCsvEntity.set資格取得年月日(set年月日(被保険者台帳.getShikakuShutokuYMD()));
        eucCsvEntity.set資格取得届出年月日(set年月日(被保険者台帳.getShikakuShutokuTodokedeYMD()));
        eucCsvEntity.set第１号資格取得年月日(set年月日(被保険者台帳.getIchigoShikakuShutokuYMD()));
        eucCsvEntity.set被保険者区分コード(被保険者台帳.getHihokennshaKubunCode());
        eucCsvEntity.set被保険者区分(HihokenshaKubunCode.toValue(被保険者台帳.getHihokennshaKubunCode()).get名称());
        eucCsvEntity.set資格喪失事由コード(被保険者台帳.getShikakuSoshitsuJiyuCode());
        if (!RString.isNullOrEmpty(被保険者台帳.getShikakuSoshitsuJiyuCode())) {
            eucCsvEntity.set資格喪失事由(jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu.toValue(
                    被保険者台帳.getShikakuSoshitsuJiyuCode()).get名称());
        }
        eucCsvEntity.set資格喪失年月日(set年月日(被保険者台帳.getShikakuSoshitsuYMD()));
        eucCsvEntity.set資格喪失届出年月日(set年月日(被保険者台帳.getShikakuSoshitsuTodokedeYMD()));
        eucCsvEntity.set資格変更事由コード(被保険者台帳.getShikakuHenkoJiyuCode());
        eucCsvEntity.set資格変更事由(ShikakuHenkoJiyu.toValue(被保険者台帳.getShikakuHenkoJiyuCode()).get名称());
        eucCsvEntity.set資格変更年月日(set年月日(被保険者台帳.getShikakuHenkoYMD()));
        eucCsvEntity.set資格変更届出年月日(set年月日(被保険者台帳.getShikakuHenkoTodokedeYMD()));
        eucCsvEntity.set住所地特例適用事由コード(被保険者台帳.getJushochitokureiTekiyoJiyuCode());
        if (!RString.isNullOrEmpty(被保険者台帳.getJushochitokureiTekiyoJiyuCode())) {
            eucCsvEntity.set住所地特例適用事由(ShikakuJutokuTekiyoJiyu.toValue(被保険者台帳.getJushochitokureiTekiyoJiyuCode()).get名称());
        }
        eucCsvEntity.set適用年月日(set年月日(被保険者台帳.getJushochitokureiTekiyoYMD()));
        eucCsvEntity.set適用届出年月日(set年月日(被保険者台帳.getJushochitokureiTekiyoTodokedeYMD()));
        eucCsvEntity.set住所地特例解除事由コード(被保険者台帳.getJushochitokureiKaijoJiyuCode());
        if (!RString.isNullOrEmpty(被保険者台帳.getJushochitokureiKaijoJiyuCode())) {
            eucCsvEntity.set住所地特例解除事由(ShikakuJutokuKaijoJiyu.toValue(被保険者台帳.getJushochitokureiKaijoJiyuCode()).get名称());
        }
        eucCsvEntity.set解除年月日(set年月日(被保険者台帳.getJushochitokureiKaijoYMD()));
        eucCsvEntity.set解除届出年月日(set年月日(被保険者台帳.getJushochitokureiKaijoTodokedeYMD()));
        eucCsvEntity.set住所地特例フラグ(被保険者台帳.getJushochiTokureiFlag());
        eucCsvEntity.set広域内住所地特例フラグ(被保険者台帳.getKoikinaiJushochiTokureiFlag());
        LasdecCode 広住特措置元市町村コード = 被保険者台帳.getKoikinaiTokureiSochimotoShichosonCode();
        if (広住特措置元市町村コード != null) {
            eucCsvEntity.set広住特措置元市町村コード(広住特措置元市町村コード.value());
        }
        LasdecCode 旧市町村コード = 被保険者台帳.getKyuShichosonCode();
        if (旧市町村コード != null) {
            eucCsvEntity.set旧市町村コード(旧市町村コード.value());
        }
        eucCsvEntity.set住民異動情報_異動事由コード(住民異動情報.getIdoJiyuCode());
        eucCsvEntity.set住民異動情報_異動事由(JukiIdoJiyu.toValue(住民異動情報.getIdoJiyuCode()).get異動事由略称());
        eucCsvEntity.set異動年月日(set年月日(住民異動情報.getIdoYMD()));
        eucCsvEntity.set届出年月日(set年月日(住民異動情報.getTodokedeYMD()));
        RString 住民種別コード = 住民異動情報.getJuminShubetsuCode();
        if (JuminShubetsu.日本人.getCode().equals(住民種別コード) || JuminShubetsu.住登外個人_日本人.getCode().equals(住民種別コード)) {
            AtenaMeisho 漢字氏名 = 住民異動情報.getKanjiShimei();
            if (漢字氏名 != null) {
                eucCsvEntity.set氏名(漢字氏名.value());
            }
            AtenaKanaMeisho カナ氏名 = 住民異動情報.getKanaShimei();
            if (カナ氏名 != null) {
                eucCsvEntity.setカナ氏名(カナ氏名.value());
            }
        } else if (JuminShubetsu.外国人.getCode().equals(住民種別コード) || JuminShubetsu.住登外個人_外国人.getCode().equals(住民種別コード)) {
            AtenaMeisho 外国人氏名 = 住民異動情報.getGaikokujinShimei();
            if (外国人氏名 != null) {
                eucCsvEntity.set氏名(外国人氏名.value());
            }
            AtenaKanaMeisho 外国人カナ氏名 = 住民異動情報.getGaikokujinKanaShimei();
            if (外国人カナ氏名 != null) {
                eucCsvEntity.setカナ氏名(外国人カナ氏名.value());
            }
        }
        eucCsvEntity.set生年月日(set年月日(住民異動情報.getSeinengappiYMD()));
        eucCsvEntity.set性別(Seibetsu.toValue(住民異動情報.getSeibetsuCode()).get名称());
        return eucCsvEntity;
    }

    private RString set被保険者台帳_異動事由(RString 被保険者台帳_異動事由コード) {
        for (ShikakuShutokuJiyu shikakuShutokuJiyu : ShikakuShutokuJiyu.values()) {
            if (shikakuShutokuJiyu.getコード().equals(被保険者台帳_異動事由コード)) {
                return shikakuShutokuJiyu.get名称();
            }
        }
        for (jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu shikakuSoshitsuJiyu
                : jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu.values()) {
            if (shikakuSoshitsuJiyu.getコード().equals(被保険者台帳_異動事由コード)) {
                return shikakuSoshitsuJiyu.get名称();
            }
        }
        for (ShikakuHenkoJiyu shikakuHenkoJiyu : ShikakuHenkoJiyu.values()) {
            if (shikakuHenkoJiyu.getコード().equals(被保険者台帳_異動事由コード)) {
                return shikakuHenkoJiyu.get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString set年月日(FlexibleDate 年月日) {
        if (年月日 == null || 年月日.isEmpty()) {
            return RString.EMPTY;
        }
        return 年月日.seireki().separator(Separator.SLASH).fillType(FillType.ZERO).toDateString();
    }
}
