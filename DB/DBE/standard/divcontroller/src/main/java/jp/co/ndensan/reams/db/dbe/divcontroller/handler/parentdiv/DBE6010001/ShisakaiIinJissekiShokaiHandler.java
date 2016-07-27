/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranBatchParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinHoshukubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.dgShisakaiIinJisseki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.ui.servlets.CommonButtonHolder;

/**
 * 審査会委員実績照会の画面処理Handlerクラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public class ShisakaiIinJissekiShokaiHandler {

    private static final RString 集計表を発行する = new RString("btnPulish");
    private static final RString CSVを出力する = new RString("btnShutsutyoku");
    private static final RString 条件に戻る = new RString("btnBackToKensaku");
    private final ShisakaiIinJissekiShokaiDiv div;

    /**
     * コンストラクタです。
     *
     * @param div 画面情報
     */
    public ShisakaiIinJissekiShokaiHandler(ShisakaiIinJissekiShokaiDiv div) {
        this.div = div;
    }

    /**
     * 画面初期状態の設定です。
     */
    public void set初期状態() {
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
        div.getTxtMaxKensu().setMaxValue(new Decimal(DbBusinessConfig
                .get(ConfigNameDBU.検索制御_最大取得件数上限, RDate.getNowDate(), SubGyomuCode.DBU介護統計報告).toString()));
        CommonButtonHolder.setVisibleByCommonButtonFieldName(集計表を発行する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, false);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, false);
        div.getShisakaiIinJisseki().setDisplayNone(true);
        div.getShinsakaiKaisaibi().setDisplayNone(false);
    }

    /**
     * 条件をクリアする」ボタンを押します。
     */
    public void onClick_BtnKensakuClear() {
        div.getTxtShinsakaiKaisaibi().clearFromValue();
        div.getTxtShinsakaiKaisaibi().clearToValue();
        div.getTxtMaxKensu().clearValue();
    }

    /**
     * 画面一覧状態の設定です。
     */
    public void set一覧状態() {
        CommonButtonHolder.setVisibleByCommonButtonFieldName(集計表を発行する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(CSVを出力する, true);
        CommonButtonHolder.setVisibleByCommonButtonFieldName(条件に戻る, true);
        div.getShisakaiIinJisseki().setDisplayNone(false);
        div.getShinsakaiKaisaibi().setDisplayNone(true);
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param shinsaiinjissekiichiranList 審査会委員実績照会
     */
    public void onClick_BtnKensaku(List<ShinsaiinJissekiIchiran> shinsaiinjissekiichiranList) {
        List<dgShisakaiIinJisseki_Row> rowList = new ArrayList<>();
        for (ShinsaiinJissekiIchiran data : shinsaiinjissekiichiranList) {
            dgShisakaiIinJisseki_Row row = new dgShisakaiIinJisseki_Row(data.getコード(),
                    data.get氏名(),
                    ShinsakaiIinHoshukubun.toValue(data.get報酬区分()).get名称(),
                    data.get所属機関(),
                    data.get審査会地区(),
                    data.get審査会番号(),
                    dateFormat(data.get実施日()),
                    set時刻(data.get開始()),
                    set時刻(data.get終了()),
                    KaigoninteiShinsakaiGichoKubunCode.toValue(data.get審査員種別()).get名称(),
                    IsShusseki.toValue(data.is出欠()).get名称(),
                    data.get実施年月日(),
                    new RString(Integer.toString(data.get連番())));
            rowList.add(row);
        }
        div.getDgShisakaiIinJisseki().setDataSource(rowList);
    }

    /**
     * バッチパラメータを作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @return バッチパラメータ
     */
    public ShinsaiinJissekiIchiranBatchParameter createBatchParam(RString 帳票出力区分) {
        ShinsaiinJissekiIchiranBatchParameter param = new ShinsaiinJissekiIchiranBatchParameter();
        List<ShinsaiinJissekiIchiranKey> keyJoho = new ArrayList<>();
        for (dgShisakaiIinJisseki_Row row : div.getDgShisakaiIinJisseki().getSelectedItems()) {
            if (row.getSelected()) {
                ShinsaiinJissekiIchiranKey key = new ShinsaiinJissekiIchiranKey();
                key.setShinsakaiIinCode(row.getCode());
                if (ShinsakaiIinHoshukubun.その他報酬.get名称().equals(row.getHoshuKubun())) {
                    key.setShinsakaiIinHoshuKubun(ShinsakaiIinHoshukubun.その他報酬.getコード());
                } else if (ShinsakaiIinHoshukubun.審査報酬.get名称().equals(row.getHoshuKubun())) {
                    key.setShinsakaiIinHoshuKubun(ShinsakaiIinHoshukubun.審査報酬.getコード());
                }
                key.setShinsakaiKaisaiYMD(row.getShinsakaiKaisaiYMD());
                key.setRemban(Integer.parseInt(row.getRemban().toString()));
                keyJoho.add(key);
            }
        }
        param.setKeyJoho(keyJoho);
        FlexibleDate 審査会開催日FROM = FlexibleDate.EMPTY;
        FlexibleDate 審査会開催日TO = FlexibleDate.EMPTY;
        if (div.getTxtShinsakaiKaisaibi().getFromValue() != null) {
            審査会開催日FROM = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getFromValue().toDateString());
        }
        if (div.getTxtShinsakaiKaisaibi().getToValue() != null) {
            審査会開催日TO = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getToValue().toDateString());
        }
        param.setShinsakaikaisaibiFrom(審査会開催日FROM);
        param.setShinsakaikaisaibiTo(審査会開催日TO);
        param.setSyohyoSyuturyoku(帳票出力区分);
        return param;
    }

    /**
     * MybatisParametaをセート。
     *
     * @return ShinsaiinJissekiIchiranMybitisParamter
     */
    public ShinsaiinJissekiIchiranMybitisParamter setMybatisParameta() {
        FlexibleDate 審査会開催日FROM = FlexibleDate.EMPTY;
        FlexibleDate 審査会開催日TO = FlexibleDate.EMPTY;
        if (div.getTxtShinsakaiKaisaibi().getFromValue() != null) {
            審査会開催日FROM = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getFromValue().toDateString());
        }
        if (div.getTxtShinsakaiKaisaibi().getToValue() != null) {
            審査会開催日TO = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getToValue().toDateString());
        }
        ShinsaiinJissekiIchiranMybitisParamter paramter = ShinsaiinJissekiIchiranMybitisParamter.createParamter(false,
                審査会開催日FROM, 審査会開催日TO, new RString(div.getTxtMaxKensu().getValue().toString()));
        return paramter;
    }

    /**
     * CommonButtonHolderをセート
     */
    public void setCommonButton() {
        if (div.getDgShisakaiIinJisseki().getDataSource().isEmpty()) {
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnPulish"), false);
            CommonButtonHolder.setVisibleByCommonButtonFieldName(new RString("btnShutsutyoku"), false);
        }
    }

    private RString set時刻(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RTime datetime = new RTime(date);
        return datetime.toFormattedTimeString(DisplayTimeFormat.HH_mm);
    }

    private RString dateFormat(RString date) {
        if (RString.isNullOrEmpty(date)) {
            return RString.EMPTY;
        }
        RDate date_tem = new RDate(date.toString());
        return date_tem.wareki().toDateString();
    }
}
