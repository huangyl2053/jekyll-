/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.entity.commonchilddiv.TaishoshaIchiran.TaishoshaIchiran;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.kyodojukyushataishosha.KyodoJukyushaTaishoshaEntity;
import jp.co.ndensan.reams.db.dbc.divcontroller.viewbox.taishoshaichiran.TaishoshaIchiranParameter;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.binding.DataGridCellBgColor;
import jp.co.ndensan.reams.uz.uza.util.serialization.DataPassingConverter;

/**
 * 対象者一覧共有子DivのHandler
 *
 * @reamsid_L DBC-4471-010 xupeng
 */
public final class TaishoshaIchiranDivHandler {

    private final TaishoshaIchiranDiv div;
    private static final RString 受給者異動連絡票変更登録 = new RString("DBCMN81002");
    private static final RString 共同処理用受給者異動連絡票変更登録 = new RString("DBCMN81004");
    private static final RString 受給者異動_訂正連絡票発行 = new RString("DBCMN83001");
    private static final RString 受給者異動連絡票情報照会 = new RString("DBCMN11007");
    private static final RString 共同処理用受給者異動_訂正連絡票発行 = new RString("DBCMN83002");
    private static final RString 共同処理用受給者異動連絡票情報照会 = new RString("DBCMN11008");
    private static final RString 修正モード = new RString("修正");
    private static final RString 選択モード = new RString("選択");

    private TaishoshaIchiranDivHandler(TaishoshaIchiranDiv div) {
        this.div = div;
    }

    /**
     * コンストラクタです。
     *
     * @param div 画面DIV
     * @return TaishoshaIchiranDivHandler
     */
    public static TaishoshaIchiranDivHandler of(TaishoshaIchiranDiv div) {
        return new TaishoshaIchiranDivHandler(div);
    }

    /**
     * 初期化設定
     *
     * @param メニューID RString
     * @param 被保険者番号 HihokenshaNo
     * @param 異動日From FlexibleDate
     * @param 異動日To FlexibleDate
     * @param 表示モード RString
     * @param 削除データ検索 RString
     * @param 対象者一覧情報 List<KyodoJukyushaTaishoshaEntity>
     */
    public void initialize(RString メニューID, HihokenshaNo 被保険者番号, FlexibleDate 異動日From,
            FlexibleDate 異動日To, RString 表示モード, RString 削除データ検索,
            List<KyodoJukyushaTaishoshaEntity> 対象者一覧情報) {
        if (メニューID != null && !メニューID.isEmpty()) {
            div.setMenuID(メニューID);
        }
        if (受給者異動連絡票変更登録.equals(メニューID) || 共同処理用受給者異動連絡票変更登録.equals(メニューID)) {
            表示モード = 修正モード;
        } else if (受給者異動_訂正連絡票発行.equals(メニューID) || 受給者異動連絡票情報照会.equals(メニューID)
                || 共同処理用受給者異動_訂正連絡票発行.equals(メニューID) || 共同処理用受給者異動連絡票情報照会.equals(メニューID)) {
            表示モード = 選択モード;
        }

        if (修正モード.equals(表示モード)) {
            div.setMode_State(TaishoshaIchiranDiv.State.ModifyMode);
        } else if (選択モード.equals(表示モード)) {
            div.setMode_State(TaishoshaIchiranDiv.State.SelectMode);
        }

        if (対象者一覧情報 != null && !対象者一覧情報.isEmpty()) {
            setGrid(対象者一覧情報);
        }
        if (異動日From != null && !異動日From.isEmpty()) {
            div.setIdoFromYMD(DataPassingConverter.serialize(異動日From));
        }
        if (異動日To != null && !異動日To.isEmpty()) {
            div.setIdoToYMD(DataPassingConverter.serialize(異動日To));
        }
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            div.setHihoNo(DataPassingConverter.serialize(被保険者番号));
        }
        div.setDeleteDateFlag(削除データ検索);
    }

    private void setGrid(List<KyodoJukyushaTaishoshaEntity> 対象者一覧情報) {
        List<dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row> list = new ArrayList<>();
        for (KyodoJukyushaTaishoshaEntity entity : 対象者一覧情報) {
            dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row row = new dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row();
            if (entity.get異動日() != null && !entity.get異動日().isEmpty()) {
                row.getTxtResultIdoDate().setValue(new RDate(entity.get異動日().toString()));
            }
            if (entity.get対象年月() != null && !entity.get対象年月().isEmpty()) {
                row.getTxtTaishoNengetsu().setValue(new RDate(entity.get対象年月().toString()));
            }
            if (entity.get被保番号() != null && !entity.get被保番号().isEmpty()) {
                row.getTxtResultHihoNo().setValue(entity.get被保番号().value());
            }
            if (entity.get被保険者氏名() != null && !entity.get被保険者氏名().isEmpty()) {
                row.getTxtResultHihoName().setValue(entity.get被保険者氏名());
            }
            row.setTxtRirekiNo(new RString(String.valueOf(entity.get履歴番号())));
            if (entity.is論理削除フラグ()) {
                row.setTxtDeleteFlag(new RString(Boolean.TRUE.toString()));
                row.setRowBgColor(DataGridCellBgColor.bgColorRed);
            } else {
                row.setTxtDeleteFlag(new RString(Boolean.FALSE.toString()));
            }
            list.add(row);
        }
        div.getDgJukyushaIdoRenrakuhyoHenkoSearchResultList().setDataSource(list);
    }

    /**
     * 該当者一覧で選択した行の検索キー
     *
     * @return KyodoJukyushaTaishoshaEntity
     */
    public KyodoJukyushaTaishoshaEntity set選択行検索キー() {
        dgJukyushaIdoRenrakuhyoHenkoSearchResultList_Row row = div.getDgJukyushaIdoRenrakuhyoHenkoSearchResultList().getClickedItem();
        KyodoJukyushaTaishoshaEntity entity = new KyodoJukyushaTaishoshaEntity();
        if (row.getTxtResultIdoDate().getValue() != null) {
            entity.set異動日(new FlexibleDate(row.getTxtResultIdoDate().getValue().toString()));
        }
        if (row.getTxtResultHihoNo().getValue() != null && !row.getTxtResultHihoNo().getValue().isEmpty()) {
            entity.set被保番号(new HihokenshaNo(row.getTxtResultHihoNo().getValue()));
        }
        if (row.getTxtDeleteFlag() != null) {
            if (row.getTxtDeleteFlag().toString().equals(Boolean.TRUE.toString())) {
                entity.set論理削除フラグ(true);
            } else if (row.getTxtDeleteFlag().toString().equals(Boolean.FALSE.toString())) {
                entity.set論理削除フラグ(false);
            }
        }
        RString メニューID = div.getMenuID();
        if (受給者異動連絡票変更登録.equals(メニューID)
                || 受給者異動_訂正連絡票発行.equals(メニューID)
                || 受給者異動連絡票情報照会.equals(メニューID)) {
            if (row.getTxtRirekiNo() != null && !row.getTxtRirekiNo().isEmpty()) {
                entity.set履歴番号(Integer.parseInt(row.getTxtRirekiNo().toString()));
            }
        } else if ((共同処理用受給者異動連絡票変更登録.equals(メニューID)
                || 共同処理用受給者異動_訂正連絡票発行.equals(メニューID)
                || 共同処理用受給者異動連絡票情報照会.equals(メニューID))
                && row.getTxtTaishoNengetsu().getValue() != null) {
            entity.set対象年月(new FlexibleYearMonth(row.getTxtTaishoNengetsu().
                    getValue().getYearMonth().toString()));
        }
        return entity;
    }

    /**
     * 検索条件の（登録退避用）
     *
     * @return TaishoshaIchiranParameter
     */
    public TaishoshaIchiranParameter set登録退避用検索キー() {
        FlexibleDate 異動日From = DataPassingConverter.deserialize(div.getIdoFromYMD(), FlexibleDate.class);
        FlexibleDate 異動日To = DataPassingConverter.deserialize(div.getIdoToYMD(), FlexibleDate.class);
        HihokenshaNo 被保険者番号 = DataPassingConverter.deserialize(div.getHihoNo(), HihokenshaNo.class);
        RString 削除データ検索 = div.getDeleteDateFlag();
        TaishoshaIchiranParameter parameter = new TaishoshaIchiranParameter(異動日From, 異動日To,
                被保険者番号, 削除データ検索);
        return parameter;
    }

}
