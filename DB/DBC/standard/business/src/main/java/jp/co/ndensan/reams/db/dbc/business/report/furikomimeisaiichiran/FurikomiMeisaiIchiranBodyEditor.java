/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.furikomimeisaiichiran;

import jp.co.ndensan.reams.db.dbc.entity.db.relate.furikaego.FurikaeGoMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.report.furikomimeisaiichiran.FurikomiMeisaiIchiranSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票設計_DBC200003_事業合算・事業分振込明細書作成（一括） HeaderEditorクラスです。
 *
 * @reamsid_L DBC-4870-060 lijian
 */
public class FurikomiMeisaiIchiranBodyEditor implements IFurikomiMeisaiIchiranEditor {

    private final FurikaeGoMeisaiEntity 振込明細一覧Entity;

    /**
     * コンストラクタです。
     *
     * @param 振込明細一覧Entity FurikaeGoMeisaiEntity
     */
    public FurikomiMeisaiIchiranBodyEditor(FurikaeGoMeisaiEntity 振込明細一覧Entity) {
        this.振込明細一覧Entity = 振込明細一覧Entity;
    }

    @Override
    public FurikomiMeisaiIchiranSource edit(FurikomiMeisaiIchiranSource source) {

        if (振込明細一覧Entity.get被保険者番号() != null) {
            source.List1_1 = 振込明細一覧Entity.get被保険者番号().value();
        }
        if (振込明細一覧Entity.get被保険者氏名() != null) {
            source.List1_2 = 振込明細一覧Entity.get被保険者氏名().value();
        }
        source.List1_3 = 振込明細一覧Entity.get支給申請書整理番号();
        if (振込明細一覧Entity.get申請年月日() != null) {
            source.List1_4 = new RString(振込明細一覧Entity.get申請年月日().toString());
        }
        source.List1_5 = 振込明細一覧Entity.get申請種類();
        if (振込明細一覧Entity.get認定有効期間開始() != null) {
            source.List1_6 = new RString(振込明細一覧Entity.get認定有効期間開始().toString());
        }
        if (振込明細一覧Entity.get自己負担総額円() != null) {
            source.List1_7 = new RString(振込明細一覧Entity.get自己負担総額円().toString());
        }
        source.List1_8 = 振込明細一覧Entity.get上段();

        if (振込明細一覧Entity.get対象年度() != null) {
            source.List2_1 = 振込明細一覧Entity.get対象年度().toDateString();
        }
        source.List2_2 = 振込明細一覧Entity.get住所();
        if (振込明細一覧Entity.get計算対象期間() != null) {
            source.List2_3 = new RString(振込明細一覧Entity.get計算対象期間().toString());
        }
        if (振込明細一覧Entity.get決定年月日() != null) {
            source.List2_4 = new RString(振込明細一覧Entity.get決定年月日().toString());
        }
        source.List2_5 = 振込明細一覧Entity.get要介護度();
        if (振込明細一覧Entity.get認定有効期間終了() != null) {
            source.List2_6 = new RString(振込明細一覧Entity.get認定有効期間終了().toString());
        }
        if (振込明細一覧Entity.get支給額円() != null) {
            source.List2_7 = new RString(振込明細一覧Entity.get支給額円().toString());
        }
        source.List2_8 = 振込明細一覧Entity.get下段();

        source.List3_1 = 振込明細一覧Entity.get番号();
        source.List4_1 = 振込明細一覧Entity.get支払方法();
        source.List5_1 = 振込明細一覧Entity.get名寄せ();

        source.ninzu_shokei = new RString(振込明細一覧Entity.get頁計人数());
        if (振込明細一覧Entity.get頁計金額() != null) {
            source.shikyu_shokei = new RString(振込明細一覧Entity.get頁計金額().toString());
        }
        source.yoshien_ninzu_gokei = new RString(振込明細一覧Entity.get総合計要支援人数());
        if (振込明細一覧Entity.get総合計要支援金額() != null) {
            source.yoshien_kingaku_gokei = new RString(振込明細一覧Entity.get総合計要支援金額().toString());
        }
        source.jigyotaisho_ninzu_gokei = new RString(振込明細一覧Entity.get総合計事業対象人数());
        if (振込明細一覧Entity.get総合計事業対象金額() != null) {
            source.jigyotaisho_kingaku_gokei = new RString(振込明細一覧Entity.get総合計事業対象金額().toString());
        }
        source.fumei_ninzu_gokei = new RString(振込明細一覧Entity.get総合計不明人数());
        if (振込明細一覧Entity.get総合計不明金額() != null) {
            source.fumei_kingaku_gokei = new RString(振込明細一覧Entity.get総合計不明金額().toString());
        }
        source.ninzu_gokei = new RString(振込明細一覧Entity.get総合計人数());
        if (振込明細一覧Entity.get総合計金額() != null) {
            source.shikyu_gokei = new RString(振込明細一覧Entity.get総合計金額().toString());
        }
        return source;
    }

}
