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
import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.ShinsakaiIinShubetsu;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranKey;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShisakaiIinJissekiIchiranShinsakaiTanka;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsaiinjissekiichiran.ShisakaiIinJissekiIchiranShozokuKikan;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.IsShusseki;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.KaigoninteiShinsakaiGichoKubunCode;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shinsaiinjissekiichiran.ShinsaiinJissekiIchiranMybitisParamter;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.ShisakaiIinJissekiShokaiDiv;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6010001.dgShisakaiIinJisseki_Row;
import jp.co.ndensan.reams.db.dbe.divcontroller.entity.parentdiv.DBE6030001.DBE6030001StateName;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.Sikaku;
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
    private static final RString KEY_出力方法_初期値 = new RString("1");
    private static final RString 審査会単価パターン = DbBusinessConfig.get(ConfigNameDBE.審査員単価パターン, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    private static final RString 審査会単価パターン_委員 = ShisakaiIinJissekiIchiranShinsakaiTanka.審査会単価パターン_委員.getコード();
    private static final RString 審査会単価パターン_医師 = ShisakaiIinJissekiIchiranShinsakaiTanka.審査会単価パターン_医師.getコード();
    RString 審査会委員実績照会_医師範囲_歯科医師 = DbBusinessConfig.get(ConfigNameDBE.審査会委員実績照会_医師範囲_歯科医師, RDate.getNowDate(), SubGyomuCode.DBE認定支援);
    private static final RString 医師範囲に歯科医師含む = new RString("1");
    private static final RString 所属機関_医療機関 = ShisakaiIinJissekiIchiranShozokuKikan.医療機関.get名称();
    private static final RString 所属機関_調査委託先 = ShisakaiIinJissekiIchiranShozokuKikan.調査委託先.get名称();
    private static final RString 所属機関_その他機関 = ShisakaiIinJissekiIchiranShozokuKikan.その他機関.get名称();

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
        div.getRadShutsuryokuHoho().setSelectedKey(KEY_出力方法_初期値);
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
        div.getDgShisakaiIinJisseki().setDataSource(setDgShisakaiIinJisseki_Row(shinsaiinjissekiichiranList));
        if (searchResult.exceedsLimit()) {
            div.getDgShisakaiIinJisseki().getGridSetting().setLimitRowCount(shinsaiinjissekiichiranList.size());
            div.getDgShisakaiIinJisseki().getGridSetting().setSelectedRowCount(searchResult.totalCount());
        } else {
            div.getDgShisakaiIinJisseki().getGridSetting().setLimitRowCount(div.getTxtMaxKensu().getValue().intValue());
            div.getDgShisakaiIinJisseki().getGridSetting().setSelectedRowCount(searchResult.totalCount());
        }
        return null;
    }

    private List<dgShisakaiIinJisseki_Row> setDgShisakaiIinJisseki_Row(List<ShinsaiinJissekiIchiran> shinsaiinjissekiichiranList) {
        List<dgShisakaiIinJisseki_Row> rowList = new ArrayList<>();
        RString 所属機関の種類;

        for (ShinsaiinJissekiIchiran data : shinsaiinjissekiichiranList) {
            所属機関の種類 = get所属機関の種類(data);
            dgShisakaiIinJisseki_Row row = new dgShisakaiIinJisseki_Row(data.getコード(),
                    data.get氏名(),
                    get審査員種別(data),
                    IsShusseki.toValue(data.is出欠()).get名称(),
                    get所属機関コード(data, 所属機関の種類),
                    get所属機関名称(data, 所属機関の種類),
                    所属機関の種類,
                    data.get審査会地区(),
                    data.get審査会番号(),
                    dateFormat(data.get実施日()),
                    set時刻(data.get開始()),
                    set時刻(data.get終了()),
                    get報酬単価(data));
            rowList.add(row);
        }
        return rowList;
    }

    private RString get審査員種別(ShinsaiinJissekiIchiran data) {
        if (審査会単価パターン.equals(審査会単価パターン_委員)) {
            if (data.get議長区分コード().equals(KaigoninteiShinsakaiGichoKubunCode.議長.getコード())) {
                return ShinsakaiIinShubetsu.委員長.get名称();
            } else {
                return ShinsakaiIinShubetsu.委員.get名称();
            }
        }
        if (審査会単価パターン.equals(審査会単価パターン_医師)) {
            if (data.get審査員資格コード().equals(Sikaku.医師.getコード())) {
                return ShinsakaiIinShubetsu.医師.get名称();
            } else if (医師範囲に歯科医師含む.equals(審査会委員実績照会_医師範囲_歯科医師) && data.get審査員資格コード().equals(Sikaku.歯科医師.getコード())) {
                return ShinsakaiIinShubetsu.医師.get名称();
            } else {
                return ShinsakaiIinShubetsu.医師以外.get名称();
            }
        }
        return RString.EMPTY;
    }

    private RString get所属機関の種類(ShinsaiinJissekiIchiran data) {
        if (!RString.isNullOrEmpty(data.get医療機関コード())) {
            return 所属機関_医療機関;
        }
        if (!RString.isNullOrEmpty(data.get調査委託先コード())) {
            return 所属機関_調査委託先;
        }
        if (!RString.isNullOrEmpty(data.getその他機関コード())) {
            return 所属機関_その他機関;
        }
        return RString.EMPTY;
    }

    private RString get所属機関コード(ShinsaiinJissekiIchiran data, RString 所属機関の種類) {
        if (所属機関の種類.equals(所属機関_医療機関)) {
            return data.get医療機関コード();
        }
        if (所属機関の種類.equals(所属機関_調査委託先)) {
            return data.get調査委託先コード();
        }
        if (所属機関の種類.equals(所属機関_その他機関)) {
            return data.getその他機関コード();
        }
        return RString.EMPTY;
    }

    private RString get所属機関名称(ShinsaiinJissekiIchiran data, RString 所属機関の種類) {
        if (所属機関の種類.equals(所属機関_医療機関)) {
            return data.get医療機関名称();
        }
        if (所属機関の種類.equals(所属機関_調査委託先)) {
            return data.get調査委託先名称();
        }
        if (所属機関の種類.equals(所属機関_その他機関)) {
            return data.getその他機関名称();
        }
        return RString.EMPTY;
    }

    private RString get報酬単価(ShinsaiinJissekiIchiran data) {
        if (data.is出欠()) {
            if (審査会単価パターン.equals(審査会単価パターン_委員)) {
                return data.get単価_委員();
            }
            if (審査会単価パターン.equals(審査会単価パターン_医師)) {
                return data.get単価_医師();
            }
        }
        return new RString("0");
    }

    /**
     * バッチパラメータを作成します。
     *
     * @param 帳票出力区分 帳票出力区分
     * @param STATE
     * @return バッチパラメータ
     */
    public DBE601003_ShinsakaiiinJissekiParameter createBatchParam(RString 帳票出力区分, RString STATE) {
        DBE601003_ShinsakaiiinJissekiParameter param = new DBE601003_ShinsakaiiinJissekiParameter();
        List<ShinsaiinJissekiIchiranKey> keyJoho = new ArrayList<>();
        boolean batchflag = true;
        if (STATE.equals(DBE6030001StateName.初期表示.getName())) {
            batchflag = false;
        }
        if (batchflag) {
            for (dgShisakaiIinJisseki_Row row : div.getDgShisakaiIinJisseki().getSelectedItems()) {
                if (row.getSelected()) {
                    ShinsaiinJissekiIchiranKey key = new ShinsaiinJissekiIchiranKey();
                    key.setShinsakaiIinCode(row.getCode());
                    key.setShinsakaiKaisaiNo(row.getShinsakaiBango());
                    key.setShinsakaiKaisaiYMD(new RDate(row.getJisshibi().toString()).toDateString());
                    keyJoho.add(key);
                }
            }
        }
        param.setBatchFlag(batchflag);
        param.setKeyJoho(keyJoho);
        FlexibleDate 審査会実施日FROM = FlexibleDate.EMPTY;
        FlexibleDate 審査会実施日TO = FlexibleDate.EMPTY;
        if (div.getTxtShinsakaiKaisaibi().getFromValue() != null) {
            審査会実施日FROM = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getFromValue().toDateString());
        }
        if (div.getTxtShinsakaiKaisaibi().getToValue() != null) {
            審査会実施日TO = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getToValue().toDateString());
        }
        param.setShinsakaijisshibiFrom(審査会実施日FROM);
        param.setShinsakaijisshibiTo(審査会実施日TO);
        param.setSyohyoSyuturyoku(帳票出力区分);
        return param;
    }

    /**
     * MybatisParametaをセット。
     *
     * @return ShinsaiinJissekiIchiranMybitisParamter
     */
    public ShinsaiinJissekiIchiranMybitisParamter setMybatisParameta() {
        FlexibleDate 審査会実施日FROM = FlexibleDate.EMPTY;
        FlexibleDate 審査会実施日TO = FlexibleDate.EMPTY;
        if (div.getTxtShinsakaiKaisaibi().getFromValue() != null) {
            審査会実施日FROM = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getFromValue().toDateString());
        }
        if (div.getTxtShinsakaiKaisaibi().getToValue() != null) {
            審査会実施日TO = new FlexibleDate(div.getTxtShinsakaiKaisaibi().getToValue().toDateString());
        }
        ShinsaiinJissekiIchiranMybitisParamter paramter = ShinsaiinJissekiIchiranMybitisParamter.createParamter(false,
                審査会実施日FROM, 審査会実施日TO, new RString(div.getTxtMaxKensu().getValue().toString()), null);
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
