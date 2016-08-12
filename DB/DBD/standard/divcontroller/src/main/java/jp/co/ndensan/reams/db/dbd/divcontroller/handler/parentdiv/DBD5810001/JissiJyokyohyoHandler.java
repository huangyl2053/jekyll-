/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.divcontroller.handler.parentdiv.DBD5810001;

import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd581001.YokaigoJissiJyokyohyoParameter;
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

    private final RString 帳票キー0 = new RString("key0");
    private final RString 年齢キー0 = new RString("0");
    private final RString 年齢キー1 = new RString("1");
    private final RString 地区キー0 = new RString("key0");
    private final RString 地区キー1 = new RString("key1");
    private final RString 地区キー2 = new RString("key2");
    private final RString 地区キー3 = new RString("key3");
    private final RString 全て = new RString("ALL");
    private final RString 住所 = new RString("JUSHO");
    private final RString 行政区 = new RString("GYOSEIKU");
    private final RString 地区２ = new RString("TIKU");
    private final RString 要介護認定実施状況表 = new RString("要介護認定実施状況表（その月に申請・認定を受けた受給者の統計）");
    private final RString 要介護認定月別受給者認定者数状況表
            = new RString("要介護認定月別受給者認定者数状況表（その月に基準日時点の受給者の統計）");
    private final RString 基準キー0 = new RString("0");
    private final RString 基準キー1 = new RString("1");
    private final RString 集計単位キー0 = new RString("0");
    private final RString 集計単位キー1 = new RString("1");
    private final RString 集計単位キー2 = new RString("2");
    private final RString 受給申請事由 = new RString("ZIYU");
    private final RString 申請区分申請時 = new RString("SHINSEIZI");
    private final RString 申請区分法令 = new RString("HOUREI");

    /**
     * 画面初期化処理です。
     *
     * @param div JissiJyokyohyoDiv
     */
    public void onLoad(JissiJyokyohyoDiv div) {
        div.getJyoukenPanel().getRdoKijyun().setReadOnly(true);
        div.getJyoukenPanel().getDdlKijyunhi().setReadOnly(true);
        div.getJokenPanel().getTxtSeinen().setReadOnly(true);
        ddlChiku(div, true, true, true, true, true, true);
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
            ddlChiku(div, false, false, true, true, true, true);
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー2)) {
            ddlChiku(div, true, true, false, false, true, true);
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー3)) {
            ddlChiku(div, true, true, true, true, false, false);
        } else {
            ddlChiku(div, true, true, true, true, true, true);
        }
    }

    /**
     * バッチパラメータを設定、バッチ起動を起動します。
     *
     * @param div JissiJyokyohyoDiv
     * @param parameter YokaigoJissiJyokyohyoParameter
     */
    public void onCilck_btnJikkou(JissiJyokyohyoDiv div, YokaigoJissiJyokyohyoParameter parameter) {
        if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)) {
            parameter.set出力帳票(要介護認定実施状況表);
        } else {
            parameter.set出力帳票(要介護認定月別受給者認定者数状況表);
        }
        if (div.getJyoukenPanel().getTxtnendo() != null) {
            parameter.set対象年度(div.getJyoukenPanel().getTxtnendo().getValue());
        }
        if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)
                && div.getJyoukenPanel().getRdoKijyun().getSelectedKey().equals(基準キー0)) {
            parameter.set基準フラグ(new RString("0"));
            parameter.set基準日(div.getJyoukenPanel().getDdlKijyunhi().getLabelLText());
        } else if (div.getCyouhyouPanel().getRdoCyouhyou().getSelectedKey().equals(帳票キー0)
                && div.getJyoukenPanel().getRdoKijyun().getSelectedKey().equals(基準キー1)) {
            parameter.set基準フラグ(new RString("1"));
        } else {
        }
        if (div.getJokenPanel().getRdoNenrei().getSelectedKey().equals(年齢キー0)) {
            if (div.getJokenPanel().getTxtNenrei().getFromValue() != null) {
                parameter.set年齢From(div.getJokenPanel().getTxtNenrei().getFromValue().intValue());
            }
            if (div.getJokenPanel().getTxtNenrei().getToValue() != null) {
                parameter.set年齢To(div.getJokenPanel().getTxtNenrei().getToValue().intValue());
            }
            if (div.getJokenPanel().getTxtNenreikijyun().getValue() != null) {
                parameter.set年齢基準日(new FlexibleDate(div.getJokenPanel().getTxtNenreikijyun().getValue().toDateString()));
            }
        } else {
            parameter.set年齢From(0);
            parameter.set年齢To(0);
            parameter.set年齢基準日(FlexibleDate.EMPTY);
        }
        if (div.getJokenPanel().getRdoNenrei().getSelectedKey().equals(年齢キー1)) {
            parameter.set生年月日From(new FlexibleDate(div.getJokenPanel().getTxtSeinen().getFromValue().toDateString()));
            parameter.set生年月日To(new FlexibleDate(div.getJokenPanel().getTxtSeinen().getToValue().toDateString()));
        } else {
            parameter.set生年月日From(null);
            parameter.set生年月日To(null);
        }
        if (div.getSyukeiPanel().getRdoshinsei().getSelectedKey().equals(集計単位キー0)) {
            parameter.set集計単位(受給申請事由);
        } else if (div.getSyukeiPanel().getRdoshinsei().getSelectedKey().equals(集計単位キー1)) {
            parameter.set集計単位(申請区分申請時);
        } else if (div.getSyukeiPanel().getRdoshinsei().getSelectedKey().equals(集計単位キー2)) {
            parameter.set集計単位(申請区分法令);
        } else {
            parameter.set集計単位(null);
        }
        if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー0)) {
            set地区(parameter, 全て, Code.EMPTY, Code.EMPTY);
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー1)) {
            set地区(parameter,
                    住所,
                    new Code(div.getJokenPanel().getCcdJyuusyoStart().get町域コード().getColumnValue()),
                    new Code(div.getJokenPanel().getCcdJyuusyoEnd().get町域コード().getColumnValue()));
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー2)) {
            set地区(parameter,
                    行政区,
                    new Code(div.getJokenPanel().getCcdGyouseiStart().get行政区コード().getColumnValue()),
                    new Code(div.getJokenPanel().getCcdGyouseiEnd().get行政区コード().getColumnValue()));
        } else if (div.getJokenPanel().getDdlChiku().getSelectedKey().equals(地区キー3)) {
            set地区(parameter,
                    地区２,
                    new Code(div.getJokenPanel().getCcdChikuStart().get地区2コード().getColumnValue()),
                    new Code(div.getJokenPanel().getCcdChikuStart().get地区2コード().getColumnValue()));
        } else {
            set地区(parameter, RString.EMPTY, Code.EMPTY, Code.EMPTY);
        }
    }

    private void ddlChiku(JissiJyokyohyoDiv div,
            boolean ccdJyuusyoStart,
            boolean ccdJyuusyoEnd,
            boolean ccdChikuStart,
            boolean ccdChikuEnd,
            boolean ccdGyouseiStart,
            boolean ccdGyouseiEnd) {
        div.getJokenPanel().getCcdJyuusyoStart().setReadOnly(ccdJyuusyoStart);
        div.getJokenPanel().getCcdJyuusyoEnd().setReadOnly(ccdJyuusyoEnd);
        div.getJokenPanel().getCcdChikuStart().setReadOnly(ccdChikuStart);
        div.getJokenPanel().getCcdChikuEnd().setReadOnly(ccdChikuEnd);
        div.getJokenPanel().getCcdGyouseiStart().setReadOnly(ccdGyouseiStart);
        div.getJokenPanel().getCcdGyouseiEnd().setReadOnly(ccdGyouseiEnd);
    }

    private void set地区(YokaigoJissiJyokyohyoParameter parameter,
            RString 地区区分, Code 開始地区コード, Code 終了地区コード) {
        parameter.set地区区分(地区区分);
        parameter.set開始地区コード(開始地区コード);
        parameter.set終了地区コード(終了地区コード);
    }
}
