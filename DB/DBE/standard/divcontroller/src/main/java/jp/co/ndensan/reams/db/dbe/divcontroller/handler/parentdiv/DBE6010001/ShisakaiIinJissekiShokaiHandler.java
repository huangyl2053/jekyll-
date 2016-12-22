/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.divcontroller.handler.parentdiv.DBE6010001;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiran;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE601003.DBE601003_ShinsakaiiinJissekiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinHoshukubun;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.dgShisakaiIinJisseki_Row;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.ur.urz.definition.message.UrInformationMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.message.Message;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;

/**
 * 審査会委員実績照会の画面処理Handlerクラスです
 *
 * @reamsid_L DBE-1700-010 wanghuafeng
 */
public class ShisakaiIinJissekiShokaiHandler {

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
    }

    /**
     * 条件をクリアする」ボタンを押します。
     */
    public void onClick_BtnKensakuClear() {
        div.getTxtShinsakaiKaisaibi().clearFromValue();
        div.getTxtShinsakaiKaisaibi().clearToValue();
        div.getTxtMaxKensu().setValue(new Decimal(DbBusinessConfig.get(ConfigNameDBU.検索制御_最大取得件数, RDate.getNowDate(),
                SubGyomuCode.DBU介護統計報告).toString()));
    }

    /**
     * 「検索する」ボタンを押します。
     *
     * @param searchResult 審査会委員実績照会
     * @return 該当データがない場合はメッセージを返します。該当データがある場合は{@code null}を返します。
     */
    public Message onClick_BtnKensaku(SearchResult<ShinsaiinJissekiIchiran> searchResult) {
        List<ShinsaiinJissekiIchiran> shinsaiinjissekiichiranList = searchResult.records();
        if (shinsaiinjissekiichiranList.isEmpty()) {
            return UrInformationMessages.該当データなし.getMessage();
        }
        List<dgShisakaiIinJisseki_Row> rowList = new ArrayList<>();
        for (ShinsaiinJissekiIchiran data : shinsaiinjissekiichiranList) {
            dgShisakaiIinJisseki_Row row = new dgShisakaiIinJisseki_Row(data.getコード(),
                    data.get氏名(),
                    KaigoninteiShinsakaiGichoKubunCode.toValue(data.get審査員種別()).get名称(),
                    IsShusseki.toValue(data.is出欠()).get名称(),
                    ShinsakaiIinHoshukubun.toValue(data.get報酬区分()).get名称(),
                    data.get所属機関(),
                    data.get審査会地区(),
                    data.get審査会番号(),
                    dateFormat(data.get実施日()),
                    set時刻(data.get開始()),
                    set時刻(data.get終了()),
                    data.get実施年月日(),
                    new RString(Integer.toString(data.get連番())));
            rowList.add(row);
        }
        div.getDgShisakaiIinJisseki().setDataSource(rowList);
        if (searchResult.exceedsLimit()) {
            div.getDgShisakaiIinJisseki().getGridSetting().setLimitRowCount(shinsaiinjissekiichiranList.size());
            div.getDgShisakaiIinJisseki().getGridSetting().setSelectedRowCount(searchResult.totalCount());
        } else {
            div.getDgShisakaiIinJisseki().getGridSetting().setLimitRowCount(div.getTxtMaxKensu().getValue().intValue());
            div.getDgShisakaiIinJisseki().getGridSetting().setSelectedRowCount(searchResult.totalCount());
        }
        return null;
    }

    /**
     * バッチパラメータを作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @return バッチパラメータ
     */
    public DBE601003_ShinsakaiiinJissekiParameter createBatchParam(RString 帳票出力区分) {
        DBE601003_ShinsakaiiinJissekiParameter param = new DBE601003_ShinsakaiiinJissekiParameter();
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
