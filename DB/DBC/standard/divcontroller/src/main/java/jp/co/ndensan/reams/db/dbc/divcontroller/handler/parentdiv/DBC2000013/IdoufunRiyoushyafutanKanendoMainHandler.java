/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.divcontroller.handler.parentdiv.DBC2000013;

import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC180030.DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter;
import jp.co.ndensan.reams.db.dbc.definition.message.DbcErrorMessages;
import jp.co.ndensan.reams.db.dbc.divcontroller.entity.parentdiv.DBC2000013.IdoufunRiyoushyafutanKanendoDiv;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBC;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;

/**
 * 異動分利用者負担割合判定（過年度）のHandlerクラスです。
 *
 * @reamsid_L DBC-4940-010 wangrenze
 */
public class IdoufunRiyoushyafutanKanendoMainHandler {

    private final IdoufunRiyoushyafutanKanendoDiv div;
    private final RDateTime dateTime;

    private static final int NUM_ONE = 1;
    private static final int NUM_SEVEN = 7;

    /**
     * コンストラクタです。
     *
     * @param div IdoufunRiyoushyafutanKanendoDiv
     */
    public IdoufunRiyoushyafutanKanendoMainHandler(IdoufunRiyoushyafutanKanendoDiv div) {
        dateTime = RDate.getNowDateTime();
        this.div = div;
    }

    /**
     * 画面コントロールの初期化処理を行います。
     *
     * @param business ShoriDateKanri
     */
    public void initControl(ShoriDateKanri business) {
        FlexibleYear 年次判定年度 = business.get年度();
        FlexibleDate date = new FlexibleDate(dateTime.getDate().toDateString());
        FlexibleYear 処理年度 = NUM_SEVEN < date.getMonthValue() ? date.getYear() : date.getYear().minusYear(NUM_ONE);
        if (年次判定年度.isBefore(処理年度) || 年次判定年度.isEmpty()) {
            div.getTxtKonkaiKaishiDate().setDisabled(true);
            div.getTxtKonkaiKaishiTime().setDisabled(true);
            div.getTxtKonkaiShuryoDate().setDisabled(true);
            div.getTxtKonkaiShuryoTime().setDisabled(true);
            throw new ApplicationException(DbcErrorMessages.年次判定未処理.getMessage());
        } else {
            div.getTxtKonkaiKaishiDate().setDisabled(false);
            div.getTxtKonkaiKaishiTime().setDisabled(false);
            div.getTxtKonkaiShuryoDate().setDisabled(false);
            div.getTxtKonkaiShuryoTime().setDisabled(false);
        }
        set年次処理実施日時(business);

    }

    /**
     * 取得できたの抽出期間の設定です。
     *
     * @param business ShoriDateKanri
     */
    public void set取得できたの抽出期間(ShoriDateKanri business) {
        div.getTxtZenkaiKaishiDate().setValue(get日期(getパターン1(business.get対象開始年月日())));
        div.getTxtZenkaiKaishiTime().setValue(new RTime(getパターン141(business.get対象開始日時())));
        div.getTxtZenkaiShuryoDate().setValue(get日期(getパターン1(business.get対象終了年月日())));
        div.getTxtZenkaiShuryoTime().setValue(new RTime(getパターン141(business.get対象終了日時())));
        div.getTxtKonkaiKaishiDate().setValue(get日期(getパターン1(business.get対象終了年月日())));
        div.getTxtKonkaiKaishiTime().setValue(new RTime(getパターン141(business.get対象終了日時())));
        div.getTxtKonkaiShuryoDate().setValue(get日期(getパターン1(new FlexibleDate(dateTime.getDate().toString()))));
        div.getTxtKonkaiShuryoTime().setValue(new RTime(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
    }

    /**
     * 取得できないの抽出期間の設定です。
     *
     * @param business ShoriDateKanri
     */
    public void set取得できないの抽出期間(ShoriDateKanri business) {
        div.getTxtZenkaiKaishiDate().setValue(get日期(RString.EMPTY));
        div.getTxtZenkaiKaishiTime().setValue(new RTime(RString.EMPTY));
        div.getTxtZenkaiShuryoDate().setValue(get日期(getパターン1(business.get対象終了年月日())));
        div.getTxtZenkaiShuryoTime().setValue(new RTime(getパターン141(business.get対象終了日時())));
        div.getTxtKonkaiKaishiDate().setValue(get日期(getパターン1(business.get対象終了年月日())));
        div.getTxtKonkaiKaishiTime().setValue(new RTime(getパターン141(business.get対象終了日時())));
        div.getTxtKonkaiShuryoDate().setValue(get日期(getパターン1(new FlexibleDate(dateTime.getDate().toString()))));
        div.getTxtKonkaiShuryoTime().setValue(new RTime(dateTime.getTime().toFormattedTimeString(DisplayTimeFormat.HH_mm_ss)));
    }

    /**
     * バッチパラメータの設定です。
     *
     * @return parameter　DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter
     */
    public DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter setParameter() {
        FlexibleDate date = new FlexibleDate(dateTime.getDate().toDateString());
        FlexibleYear 処理年度 = NUM_SEVEN < date.getMonthValue() ? date.getYear() : date.getYear().minusYear(NUM_ONE);
        RDateTime 抽出開始日時 = RDateTime.convertFrom(div.getTxtKonkaiKaishiDate().getValue(), div.getTxtKonkaiKaishiTime().getValue());
        RDateTime 抽出終了日時 = RDateTime.convertFrom(div.getTxtKonkaiShuryoDate().getValue(), div.getTxtKonkaiShuryoTime().getValue());
        RString 月日 = DbBusinessConfig.get(ConfigNameDBC.利用者負担割合判定管理_年度終了月日, RDate.getNowDate(), SubGyomuCode.DBC介護給付);
        RString 年月日 = 処理年度.plusYear(NUM_ONE).toDateString().concat(月日);

        DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter parameter = new DBC180030_KanendoRiyoshaFutanwariaiHanteiParameter();
        parameter.set処理日時(dateTime);
        parameter.set基準日(div.getTxtKonkaiShuryoDate().getValue());
        parameter.set対象年度(処理年度);
        parameter.set年度終了年月日(new FlexibleDate(年月日));
        parameter.set抽出終了日時(抽出終了日時);
        parameter.set抽出開始日時(抽出開始日時);
        return parameter;
    }

    private void set年次処理実施日時(ShoriDateKanri business) {
        business.get基準日時().toDateString();
        div.getTxtNenjiShoriDate().setValue(new RDate(getパターン1(business.get基準年月日()).toString()));
        div.getTxtNenjiShoriTime().setValue(new RTime(getパターン141(business.get基準日時())));
    }

    private RDate get日期(RString 年月日) {
        if (!年月日.isNullOrEmpty()) {
            return new RDate(年月日.toString());
        }
        return null;
    }

    private RString getパターン1(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return 年月日.wareki().toDateString();
        }
        return RString.EMPTY;
    }

    private RString getパターン141(YMDHMS 日時) {
        return strToTime(日時.toDateString()).toFormattedTimeString(DisplayTimeFormat.HH_mm_ss);
    }

    private RTime strToTime(RString 日時) {
        if (日時 == null || 日時.isEmpty()) {

            return RDateTime.MIN.getTime();
        }
        return new RTime(日時);
    }

}
