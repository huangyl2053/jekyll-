/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.core.tokuchotaishoshaichiransakusei;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2019TokuchoMidoteiJohoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchotaishoshaichiransakusei.TokuchoTaishoshaIchiranSakuseiEntity;
import jp.co.ndensan.reams.ue.uex.definition.core.SeibetsuCodeNenkinTokucho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特別徴収同定候補者一覧情報取得<br/>
 * ビジネス設計_DBBBZ81003_1_特徴対象者一覧作成
 *
 * @reamsid_L DBB-1860-030 yangchenbing
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class TokuchoDouteiKouhoshaListJoho {

    private RString 不一致理由コード;
    private RString 年金情報_基礎年金番号;
    private RString 年金情報_年金コード;
    private RString 年金情報_氏名;
    private RString 年金情報_生年月日;
    private RString 年金情報_性別;
    private RString 年金情報_連番;
    private RString 年金情報_処理年度;
    private RString 住基情報_識別コード;
    private RString 住基情報_漢字氏名;
    private RString 住基情報_カナ氏名;
    private RString 住基情報_生年月日;
    private RString 住基情報_性別;
    private RString 住基情報_住民種別;
    private RString 被保険者台帳_被保険者番号;
    private DbT2019TokuchoMidoteiJohoEntity dbt2019entity;

    /**
     * コンストラクタです。
     *
     * @param resultEntity TokuchoTaishoshaIchiranSakuseiEntity
     */
    public TokuchoDouteiKouhoshaListJoho(TokuchoTaishoshaIchiranSakuseiEntity resultEntity) {
        if (resultEntity != null && resultEntity.getDbt2019entity() != null) {
            this.不一致理由コード = resultEntity.getDbt2019entity().getFuichiRiyuCode();
            this.年金情報_基礎年金番号 = resultEntity.getDbt2019entity().getKisoNenkinNo();
            this.年金情報_年金コード = resultEntity.getDbt2019entity().getNenkinCode();
            this.dbt2019entity = resultEntity.getDbt2019entity().clone();
        }
        if (resultEntity != null && resultEntity.getUet0511entity() != null) {
            this.年金情報_氏名 = resultEntity.getUet0511entity().getDtKanjiShimei();
            this.年金情報_生年月日 = resultEntity.getUet0511entity().getDtBirthDay();
            SeibetsuCodeNenkinTokucho seibetsuCode = resultEntity.getUet0511entity().getDtSeibetsu();
            this.年金情報_性別 = seibetsuCode == null ? RString.EMPTY : seibetsuCode.value().get性別コード();
            this.年金情報_連番 = new RString(resultEntity.getUet0511entity().getRenban());
            if (resultEntity.getUet0511entity().getShoriNendo() != null) {
                this.年金情報_処理年度 = resultEntity.getUet0511entity().getShoriNendo().toDateString();
            }
        }
        if (resultEntity != null && resultEntity.getUaft200entity() != null) {
            ShikibetsuCode 識別コードTemp = resultEntity.getUaft200entity().getShikibetsuCode();
            if (識別コードTemp != null) {
                this.住基情報_識別コード = 識別コードTemp.value();
            }
            AtenaMeisho 漢字氏名Temp = resultEntity.getUaft200entity().getMeisho();
            if (漢字氏名Temp != null) {
                this.住基情報_漢字氏名 = 漢字氏名Temp.value();
            }
            AtenaKanaMeisho カナ氏名Temp = resultEntity.getUaft200entity().getKanaMeisho();
            if (カナ氏名Temp != null) {
                this.住基情報_カナ氏名 = カナ氏名Temp.value();
            }
            FlexibleDate 生年月日Temp = resultEntity.getUaft200entity().getSeinengappiYMD();
            if (生年月日Temp != null) {
                this.住基情報_生年月日 = 生年月日Temp.wareki().toDateString();
            }
            this.住基情報_性別 = resultEntity.getUaft200entity().getSeibetsuCode();
            this.住基情報_住民種別 = resultEntity.getUaft200entity().getJuminShubetsuCode();
        }
        if (resultEntity != null && resultEntity.getDbt1001entity() != null
                && resultEntity.getDbt1001entity().getHihokenshaNo() != null) {
            this.被保険者台帳_被保険者番号 = resultEntity.getDbt1001entity().getHihokenshaNo().value();
        }
    }
}
