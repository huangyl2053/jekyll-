/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5810001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581001.DBD581001Parameter;
import jp.co.ndensan.reams.db.dbd.divcontroller.entity.parentdiv.DBD5810001.JissiJyokyohyoDiv;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定実施状況表（統計表）画面のHandlerです。
 *
 * @reamsid_L DBD-1771-010 chenxin
 */
public class JissiJyokyohyoHandler {

    private static final RString 帳票キー0 = new RString("key0");
    private static final RString 年齢キー0 = new RString("0");
    private static final RString 年齢キー1 = new RString("1");
    private static final RString 地区キー0 = new RString("key0");
    private static final RString 地区キー1 = new RString("key1");
    private static final RString 地区キー2 = new RString("key2");
    private static final RString 地区キー3 = new RString("key3");
    private static final RString 全て = new RString("ALL");
    private static final RString 住所 = new RString("JUSHO");
    private static final RString 行政区 = new RString("GYOSEIKU");
    private static final RString 地区２ = new RString("TIKU");
    private static final RString 要介護認定実施状況表 = new RString("要介護認定実施状況表（その月に申請・認定を受けた受給者の統計）");
    private static final RString 要介護認定月別受給者認定者数状況表
            = new RString("要介護認定月別受給者認定者数状況表（その月に基準日時点の受給者の統計）");
    private static final RString 基準キー0 = new RString("0");
    private static final RString 基準キー1 = new RString("1");
    private static final RString 集計単位キー0 = new RString("0");
    private static final RString 集計単位キー1 = new RString("1");
    private static final RString 集計単位キー2 = new RString("2");
    private static final RString 受給申請事由 = new RString("ZIYU");
    private static final RString 申請区分申請時 = new RString("SHINSEIZI");
    private static final RString 申請区分法令 = new RString("HOUREI");
    private static final RString 基準フラグ0 = new RString("0");
    private static final RString 基準フラグ1 = new RString("1");

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onLoad(JissiJyokyohyoDiv div) {
        div.getJyoukenPanel().getRdoKijyun().setReadOnly(true);
        div.getJyoukenPanel().getDdlKijyunhi().setReadOnly(true);
        div.getJokenPanel().getTxtSeinen().setReadOnly(true);
    }

    /**
     * 出力帳票ラジオを操作です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onChange_rdoCyouhyou(JissiJyokyohyoDiv div) {
        if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)) {
            div.getJyoukenPanel().getTxtnendo().setReadOnly(false);
            div.getJyoukenPanel().getRdoKijyun().setReadOnly(true);
            div.getJyoukenPanel().getDdlKijyunhi().setReadOnly(true);
        } else {
            div.getJyoukenPanel().getTxtnendo().setReadOnly(false);
            div.getJyoukenPanel().getRdoKijyun().setReadOnly(false);
            div.getJyoukenPanel().getDdlKijyunhi().setReadOnly(false);
        }
    }

    /**
     * 年齢と生年月日ラジオを操作です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onChange_rdoNenrei(JissiJyokyohyoDiv div) {
        if (div.getJokenPanel().getRdoNenrei().getSelectedKey().equals(年齢キー0)) {
            div.getJokenPanel().getTxtSeinen().setReadOnly(true);
            div.getJokenPanel().getTxtNenrei().setReadOnly(false);
            div.getJokenPanel().getTxtNenreikijyun().setReadOnly(false);
        } else {
            div.getJokenPanel().getTxtSeinen().setReadOnly(false);
            div.getJokenPanel().getTxtNenrei().setReadOnly(true);
            div.getJokenPanel().getTxtNenreikijyun().setReadOnly(true);
        }
    }

    /**
     * 地区DDLを操作です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onChange_ddlChiku(JissiJyokyohyoDiv div) {
        if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)
                && div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー1)) {
            ddlChiku(div, true, true, true, false, false, false, false, false, false);
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー2)) {
            ddlChiku(div, false, false, false, true, true, true, false, false, false);
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー3)) {
            ddlChiku(div, false, false, false, false, false, false, true, true, true);
        } else {
            ddlChiku(div, true, true, true, true, true, true, true, true, true);
        }
    }

    /**
     * バッチパラメータを設定、バッチ起動を起動します。
     *
     * @param div JissiJyokyohyoDiv
     * @param parameter YokaigoJissiJyokyohyoParameter
     */
    public void onCilck_btnBatchRegister(JissiJyokyohyoDiv div, DBD581001Parameter parameter) {
        if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)) {
            parameter.set出力帳票(要介護認定実施状況表);
        } else {
            parameter.set出力帳票(要介護認定月別受給者認定者数状況表);
        }
        parameter.set対象年度(div.getJyoukenPanel().getTxtnendo().getValue());
        if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)
                && div.getJyoukenPanel().getRdoKijyun().getSelectedKey().equals(基準キー0)) {
            parameter.set基準フラグ(基準フラグ0);
            parameter.set基準日(div.getJyoukenPanel().getDdlKijyunhi().getLabelLText());
        } else if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)
                && div.getJyoukenPanel().getRdoKijyun().getSelectedKey().equals(基準キー1)) {
            parameter.set基準フラグ(基準フラグ1);
        }
        if (div.getJokenPanel().getRdoNenrei().getSelectedKey().equals(年齢キー0)) {
            parameter.set年齢From(div.getJokenPanel().getTxtNenrei().getFromValue().intValue());
            parameter.set年齢To(div.getJokenPanel().getTxtNenrei().getToValue().intValue());
            parameter.set年齢基準日(new FlexibleDate(div.getJokenPanel().getTxtNenreikijyun().getValue().toDateString()));
        }
        if (div.getJokenPanel().getRdoNenrei().getSelectedKey().equals(年齢キー1)) {
            parameter.set生年月日From(new FlexibleDate(div.getJokenPanel().getTxtSeinen().getFromValue().toDateString()));
            parameter.set生年月日To(new FlexibleDate(div.getJokenPanel().getTxtSeinen().getToValue().toDateString()));
        }
        if (div.getSyukeiPanel().getRdoshinsei().getSelectedKey().equals(集計単位キー0)) {
            parameter.set集計単位(受給申請事由);
        } else if (div.getSyukeiPanel().getRdoshinsei().getSelectedKey().equals(集計単位キー1)) {
            parameter.set集計単位(申請区分申請時);
        } else if (div.getSyukeiPanel().getRdoshinsei().getSelectedKey().equals(集計単位キー2)) {
            parameter.set集計単位(申請区分法令);
        }
        if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー0)) {
            set地区(parameter, 全て, Code.EMPTY, Code.EMPTY);
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー1)) {
            set地区(parameter,
                    住所,
                    new Code(div.getJokenPanel().getCcdJyuusyoStart().get町域コード().value()),
                    new Code(div.getJokenPanel().getCcdJyuusyoEnd().get町域コード().value()));
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー2)) {
            set地区(parameter,
                    行政区,
                    new Code(div.getJokenPanel().getCcdGyouseiStart().get行政区コード().value()),
                    new Code(div.getJokenPanel().getCcdGyouseiEnd().get行政区コード().value()));
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー3)) {
            set地区(parameter,
                    地区２,
                    new Code(div.getJokenPanel().getCcdChikuStart().get地区2コード().value()),
                    new Code(div.getJokenPanel().getCcdChikuStart().get地区2コード().value()));
        }
    }

    private void ddlChiku(JissiJyokyohyoDiv div,
            boolean isCcdJyuusyoStartVisible,
            boolean isLblFromTo1Visible,
            boolean isCcdJyuusyoEndVisible,
            boolean isCcdChikuStartVisible,
            boolean isLblFromTo2Visible,
            boolean isCcdChikuEndVisible,
            boolean isCcdGyouseiStartVisible,
            boolean isLblFromTo3Visible,
            boolean isCcdGyouseiEndVisible) {
        div.getJokenPanel().getCcdJyuusyoStart().setVisible(isCcdJyuusyoStartVisible);
        div.getJokenPanel().getLblFromTo1().setVisible(isLblFromTo1Visible);
        div.getJokenPanel().getCcdJyuusyoEnd().setVisible(isCcdJyuusyoEndVisible);
        div.getJokenPanel().getCcdChikuStart().setVisible(isCcdChikuStartVisible);
        div.getJokenPanel().getLblFromTo2().setVisible(isLblFromTo2Visible);
        div.getJokenPanel().getCcdChikuEnd().setVisible(isCcdChikuEndVisible);
        div.getJokenPanel().getCcdGyouseiStart().setVisible(isCcdGyouseiStartVisible);
        div.getJokenPanel().getLblFromTo3().setVisible(isLblFromTo3Visible);
        div.getJokenPanel().getCcdGyouseiEnd().setVisible(isCcdGyouseiEndVisible);
    }

    private void set地区(DBD581001Parameter parameter,
            RString 地区区分, Code 開始地区コード, Code 終了地区コード) {
        parameter.set地区区分(地区区分);
        parameter.set開始地区コード(開始地区コード);
        parameter.set終了地区コード(終了地区コード);
    }
}
