/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.divcontroller.handler.parentdiv.DBU0520011;

import jp.co.ndensan.reams.db.dbu.definition.core.kyokaisogaitoshabatchparameter.KyokaisoKanriMasterListBatchParameter;
import jp.co.ndensan.reams.db.dbu.divcontroller.entity.parentdiv.DBU0520011.KyokaisouKanriMasterListPanelDiv;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoBunruiKanri;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 境界層管理マスタリストのHandlerクラスです。
 */
public class KyokaisouKanriMasterListPanelHandler {

    private final KyokaisouKanriMasterListPanelDiv div;
    private static final RString 取得モード_基準日 = new RString("1");
    private static final RString 取得モード_範囲 = new RString("2");
    private static final RString 取得モード_指定無し = new RString("3");
    private static final RString 境界層該当申請日 = new RString("1");
    private static final RString 境界層該当開始日 = new RString("2");
    private static final RString 境界層該当終了日 = new RString("3");
    private static final RString 該当内容区分 = new RString("1");
    private static final RString 該当内容区分ない = new RString("2");
    private static final RString KY1 = new RString("0");
    private static final RString KY2 = new RString("1");
    private static final RString KY3 = new RString("2");
    private static final RString KY4 = new RString("3");
    private static final RString KY5 = new RString("4");
    private static final RString KY6 = new RString("5");
    private static final RString 基準日_key0 = new RString("0");
    private static final RString 範囲_key0 = new RString("1");
    private static final RString 指定無し_key0 = new RString("2");
    private static final RString 境界層対象抽出範囲 = new RString("1");

    /**
     * コンストラクタ。
     *
     * @param div KyokaisouKanriMasterListPanelDiv
     */
    public KyokaisouKanriMasterListPanelHandler(KyokaisouKanriMasterListPanelDiv div) {
        this.div = div;
    }

    /**
     * 画面初期化処理。
     *
     * @param chohyoBunruiKanri chohyoBunruiKanri
     */
    public void initialize(ChohyoBunruiKanri chohyoBunruiKanri) {
        //TODO 出力顺ID获取已提技术点待解决。
        div.getCcdChohyoShutsuryokujun().load(SubGyomuCode.DBA介護資格, chohyoBunruiKanri.get帳票分類ID());
        div.getKyokaisoKariParam().getRadKijunbi().setSelectedKey(KY1);
        div.getKyokaisoKariParam().getTxtKijumbi().setDisabled(false);
        div.getKyokaisoKariParam().getTxtKijumbi().setValue(RDate.getNowDate());
        div.getKyokaisoKariParam().getRadHaniRadio().setDisabled(true);
        div.getKyokaisoKariParam().getTxtHaniChushutsu().setDisabled(true);
        div.getShiteiNaiyoKubun().getChkShiteiNaiyoKubun().setDisplayNone(false);
        div.getShiteiNaiyoKubun().getCcdChohyoShutsuryokujun().setVisible(true);
    }

    /**
     * 「基準日」を選択した時、コントロールの制御。
     *
     */
    public void setKijunbiState() {
        div.getKyokaisoKariParam().getTxtKijumbi().setDisabled(false);
        div.getKyokaisoKariParam().getRadHaniRadio().setDisabled(true);
        div.getKyokaisoKariParam().getTxtHaniChushutsu().setDisabled(true);
    }

    /**
     * 「範囲」を選択した時、コントロールの制御。
     */
    public void setHaniState() {
        div.getKyokaisoKariParam().getTxtKijumbi().setDisabled(true);
        div.getKyokaisoKariParam().getRadHaniRadio().setDisabled(false);
        div.getKyokaisoKariParam().getTxtHaniChushutsu().setDisabled(false);
    }

    /**
     * 「指定無し」を選択した時、コントロールの制御。
     */
    public void setShiteiNashiState() {
        div.getKyokaisoKariParam().getTxtKijumbi().setDisabled(true);
        div.getKyokaisoKariParam().getRadHaniRadio().setDisabled(true);
        div.getKyokaisoKariParam().getTxtHaniChushutsu().setDisabled(true);
    }

    /**
     * 境界層管理マスタリスト作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return batchPara 境界層管理マスタリストバッチパラメータ
     */
    public KyokaisoKanriMasterListBatchParameter setBatchParameter() {
        KyokaisoKanriMasterListBatchParameter batchPara = new KyokaisoKanriMasterListBatchParameter();

        バッチパラメータ_基準日(batchPara);
        バッチパラメータ_範囲(batchPara);
        バッチパラメータ_境界層対象抽出範囲(batchPara);
        バッチパラメータ_指定無し(batchPara);
        boolean hokenryoNofuGengakuFlag = false;
        boolean iskyuufugakuGengakuKisaiKiajoFlag = false;
        boolean ishyojunFutanGengakuGaitoFlag = false;
        boolean iskyojuhinadoFutangakugengakuGaitoFlag = false;
        boolean isshokuhiKeigengoHutangakuGaitoFlag = false;
        boolean iskogakuServicehiJogengakuGengakuGaitoFlag = false;
        if (div.getChkShiteiNaiyoKubun().getSelectedItems().size() > 0) {

            for (RString keys : div.getChkShiteiNaiyoKubun().getSelectedKeys()) {

                if (keys.equals(KY1)) {

                    batchPara.setIshokenFlag(該当内容区分);
                    hokenryoNofuGengakuFlag = true;
                }
                if (keys.equals(KY2)) {
                    batchPara.setIshyojunFutanFlag(該当内容区分);
                    iskyuufugakuGengakuKisaiKiajoFlag = true;
                }
                if (keys.equals(KY3)) {
                    batchPara.setIskogakuFlag(該当内容区分);
                    ishyojunFutanGengakuGaitoFlag = true;
                }
                if (keys.equals(KY4)) {
                    batchPara.setIskyojuhinadoFutangFlag(該当内容区分);
                    iskyojuhinadoFutangakugengakuGaitoFlag = true;
                }
                if (keys.equals(KY5)) {
                    batchPara.setIskyuufugakuFlag(該当内容区分);
                    isshokuhiKeigengoHutangakuGaitoFlag = true;
                }
                if (keys.equals(KY6)) {
                    batchPara.setIsshokuhiKeiFlag(該当内容区分);
                    iskogakuServicehiJogengakuGengakuGaitoFlag = true;
                }
            }
        }
        if (!hokenryoNofuGengakuFlag) {
            batchPara.setIshokenFlag(該当内容区分ない);
        }
        if (!iskyuufugakuGengakuKisaiKiajoFlag) {
            batchPara.setIshyojunFutanFlag(該当内容区分ない);
        }
        if (!ishyojunFutanGengakuGaitoFlag) {
            batchPara.setIskogakuFlag(該当内容区分ない);
        }
        if (!iskyojuhinadoFutangakugengakuGaitoFlag) {
            batchPara.setIskyojuhinadoFutangFlag(該当内容区分ない);
        }
        if (!isshokuhiKeigengoHutangakuGaitoFlag) {
            batchPara.setIskyuufugakuFlag(該当内容区分ない);
        }
        if (!iskogakuServicehiJogengakuGengakuGaitoFlag) {
            batchPara.setIsshokuhiKeiFlag(該当内容区分ない);
        }
        // TODO出力顺 取得方法不明
//        batchPara.setOrder_ID(new RString(div.getCcdChohyoShutsuryokujun().get出力順ID().toString()));
        return batchPara;
    }

    /**
     * 境界層管理マスタリスト作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return batchPara 境界層管理マスタリストバッチパラメータ
     */
    private void バッチパラメータ_基準日(KyokaisoKanriMasterListBatchParameter batchPara) {

        if (div.getKyokaisoKariParam().getRadKijunbi().getSelectedKey().equals(基準日_key0)) {
            batchPara.setDate_FROM(new FlexibleDate(div.getKyokaisoKariParam().getTxtKijumbi().getValue().toDateString()));
            batchPara.setDate_TO(null);
            batchPara.setMode(取得モード_基準日);
        }
    }

    /**
     * 境界層管理マスタリスト作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return batchPara 境界層管理マスタリストバッチパラメータ
     */
    private void バッチパラメータ_範囲(KyokaisoKanriMasterListBatchParameter batchPara) {
        if (div.getKyokaisoKariParam().getRadHani().getSelectedKey().equals(範囲_key0)) {
            batchPara.setMode(取得モード_範囲);
            batchPara.setDate_FROM(new FlexibleDate(div.getKyokaisoKariParam().getTxtHaniChushutsu().getFromValue().toDateString()));
            batchPara.setDate_TO(new FlexibleDate(div.getKyokaisoKariParam().getTxtHaniChushutsu().getToValue().toDateString()));
        }
    }

    /**
     * 境界層管理マスタリスト作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return batchPara 境界層管理マスタリストバッチパラメータ
     */
    private void バッチパラメータ_指定無し(KyokaisoKanriMasterListBatchParameter batchPara) {
        if (div.getKyokaisoKariParam().getRadShiteiNashi().getSelectedKey().equals(指定無し_key0)) {
            batchPara.setMode(取得モード_指定無し);
        }
    }

    /**
     * 境界層管理マスタリスト作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @return batchPara 境界層管理マスタリストバッチパラメータ
     */
    private void バッチパラメータ_境界層対象抽出範囲(KyokaisoKanriMasterListBatchParameter batchPara) {
        if (div.getKyokaisoKariParam().getRadHani().getSelectedKey().equals(境界層対象抽出範囲)) {

            if (div.getKyokaisoKariParam().getRadHaniRadio().getSelectedIndex() == 0) {

                batchPara.setRange(境界層該当申請日);
            }
            if (div.getKyokaisoKariParam().getRadHaniRadio().getSelectedIndex() == 1) {

                batchPara.setRange(境界層該当開始日);
            }
            if (div.getKyokaisoKariParam().getRadHaniRadio().getSelectedIndex() == 2) {

                batchPara.setRange(境界層該当終了日);
            }
        }
    }
}
