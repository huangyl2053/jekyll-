/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoMybatisParamater;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoProcessParameter;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.ITokuteiKojinJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 版改定の判定のバッチ処理です。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public class TokuteiKojinJohoTeikyoSetParameterProcess extends SimpleBatchProcessBase {

    private static final RString ワークフローＩＤ_特定個人情報提供 = new RString("DBUWFC2001");
    private static final RString ワークフローＩＤ_特定個人情報変更 = new RString("DBUWFC1001");
    private static final RString ワークフローＩＤ_スケジューラ = new RString("DBUWFC2002");
    private static final RString 処理日付管理マスタ_全件版改定用 = new RString("特定個人情報提供（全件／版改定用）");
    private static final RString 処理日付管理マスタ_異動用 = new RString("特定個人情報提供（異動用）");
    private static final RString 時00分00秒00 = new RString("000000");
    private static final RDateTime システム日時 = RDate.getNowDateTime();
    private static final int 年最後の月 = 3;
    private static final int 年開始の月 = 4;
    private static final int 年最後の日 = 31;
    private static final int 西暦年最後の月 = 12;
    private static final int 五年 = 5;
    private TokuteiKojinJohoTeikyoProcessParameter processParameter;
    private ITokuteiKojinJohoTeikyoMapper mapper;
    private DbT7022ShoriDateKanriEntity 処理日付管理_全件版改定用;
    private DbT7022ShoriDateKanriEntity 処理日付管理_異動用;
    private RString ワークフローID;

    /**
     * 基準年月日の判定です。
     */
    public static final RString ISMIRAIDATE;

    static {
        ISMIRAIDATE = new RString("isMiraiDate");
    }
    private OutputParameter<Boolean> isMiraiDate;
    /**
     * 新規異動区分の判定です。
     */
    public static final RString SHINKIIDOKUBUN;

    static {
        SHINKIIDOKUBUN = new RString("shinkiIdoKubun");
    }
    private OutputParameter<RString> shinkiIdoKubun;

    /**
     * 対象開始日時の判定です。
     */
    public static final RString TAISHOKAISHITIMESTAMP;

    static {
        TAISHOKAISHITIMESTAMP = new RString("taishoKaishiTimestamp");
    }
    private OutputParameter<RDateTime> taishoKaishiTimestamp;

    /**
     * 対象終了日時の判定です。
     */
    public static final RString TAISHOSHURYOTIMESTAMP;

    static {
        TAISHOSHURYOTIMESTAMP = new RString("taishoShuryoTimestamp");
    }
    private OutputParameter<RDateTime> taishoShuryoTimestamp;

    /**
     * 連携先団体内統合宛名（連携方式）の判定です。
     */
    public static final RString RENKEISAKIDANTAINAITOGOATENA;

    static {
        RENKEISAKIDANTAINAITOGOATENA = new RString("renkeisakiDantainaiTogoAtena");
    }
    private OutputParameter<RString> renkeisakiDantainaiTogoAtena;

    @Override
    protected void beforeExecute() {
        ワークフローID = processParameter.getワークフローID();
        shinkiIdoKubun = new OutputParameter<>();
        taishoKaishiTimestamp = new OutputParameter<>();
        taishoShuryoTimestamp = new OutputParameter<>();
        renkeisakiDantainaiTogoAtena = new OutputParameter<>();
        isMiraiDate = new OutputParameter<>();
        mapper = getMapper(ITokuteiKojinJohoTeikyoMapper.class);
        TokuteiKojinJohoTeikyoMybatisParamater parameter = new TokuteiKojinJohoTeikyoMybatisParamater();
        parameter.setSubGyomuCode(SubGyomuCode.DBU介護統計報告.value());
        parameter.setShoriName1(処理日付管理マスタ_全件版改定用);
        処理日付管理_全件版改定用 = mapper.getKijunYMD(parameter);
        parameter.setShoriName1(処理日付管理マスタ_異動用);
        処理日付管理_異動用 = mapper.getKijunYMD(parameter);
    }

    @Override
    protected void process() {
        if (!setParameterBy基準日時()) {
            isMiraiDate.setValue(false);
            setParameter_新規異動区分();
            setParameter_対象開始日時();
            setParameter_抽出終了日時();
            setParameter_連携先団体内統合宛名();
        } else {
            isMiraiDate.setValue(true);
        }
    }

    private boolean setParameterBy基準日時() {
        if (ワークフローＩＤ_特定個人情報提供.equals(ワークフローID)) {
            if (!isNullOrEmpty日付(処理日付管理_全件版改定用.getKijunYMD())
                    && FlexibleDate.getNowDate().isBeforeOrEquals(処理日付管理_全件版改定用.getKijunYMD())) {
                return true;
            }
        } else {
            if (FlexibleDate.getNowDate().isBeforeOrEquals(処理日付管理_異動用.getKijunYMD())) {
                return true;
            }
        }
        return false;
    }

    private void setParameter_新規異動区分() {
        if (ワークフローＩＤ_特定個人情報提供.equals(ワークフローID)) {
            int count_版番号 = mapper.getTokuteiKojinJohoHanKanriCount(ShokaiTeikyoKubun.初回提供済み.getコード());
            if (count_版番号 == 0) {
                shinkiIdoKubun.setValue(ShinkiIdoKubun.当初.getコード());
            } else {
                shinkiIdoKubun.setValue(ShinkiIdoKubun.版改定.getコード());
            }
        } else if (ワークフローＩＤ_特定個人情報変更.equals(ワークフローID)) {
            shinkiIdoKubun.setValue(ShinkiIdoKubun.再登録.getコード());
        } else if (ワークフローＩＤ_スケジューラ.equals(ワークフローID)) {
            shinkiIdoKubun.setValue(ShinkiIdoKubun.異動.getコード());
        }
    }

    private void setParameter_対象開始日時() {
        RDate システム日付 = システム日時.getDate();
        if (ワークフローＩＤ_特定個人情報提供.equals(ワークフローID)) {
            if (年開始の月 <= システム日付.getMonthValue() && システム日付.getMonthValue() <= 西暦年最後の月) {
                taishoKaishiTimestamp.setValue(RDateTime.of(new RDate(システム日付.getYearValue() + 1, 年最後の月, 年最後の日)
                        .minusYear(五年).toDateString(), 時00分00秒00));
            } else {
                taishoKaishiTimestamp.setValue(RDateTime.of(new RDate(システム日付.getYearValue(), 年最後の月, 年最後の日)
                        .minusYear(五年).toDateString(), 時00分00秒00));
            }
        } else if (ワークフローＩＤ_特定個人情報変更.equals(ワークフローID)) {
            taishoKaishiTimestamp.setValue(null);
        } else if (ワークフローＩＤ_スケジューラ.equals(ワークフローID)) {
            taishoKaishiTimestamp.setValue(処理日付管理_異動用.getTaishoShuryoTimestamp().getRDateTime());
        }
    }

    private void setParameter_抽出終了日時() {
        if (ワークフローＩＤ_特定個人情報提供.equals(ワークフローID)) {
            if (処理日付管理_異動用 != null && 処理日付管理_異動用.getTaishoShuryoTimestamp() != null
                    && !処理日付管理_異動用.getTaishoShuryoTimestamp().isEmpty()) {
                taishoShuryoTimestamp.setValue(処理日付管理_異動用.getTaishoShuryoTimestamp().getRDateTime());
            } else {
                taishoShuryoTimestamp.setValue(システム日時);
            }
        } else if (ワークフローＩＤ_特定個人情報変更.equals(ワークフローID)) {
            taishoShuryoTimestamp.setValue(null);
        } else if (ワークフローＩＤ_スケジューラ.equals(ワークフローID)) {
            taishoShuryoTimestamp.setValue(システム日時);
        }
    }

    private void setParameter_連携先団体内統合宛名() {
        renkeisakiDantainaiTogoAtena.setValue(DbBusinessConfig.get(
                ConfigNameDBU.番号制度_連携先団体内統合宛名_連携方式, システム日時.getDate(), SubGyomuCode.DBU介護統計報告));
    }

    private boolean isNullOrEmpty日付(FlexibleDate 日付) {
        return 日付 == null || 日付.isEmpty();
    }
}
