/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.RenkeisakiDantainaiTogoAtena;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo.ITokuteiKojinJohoTeikyoMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.uz.uza.batch.process.OutputParameter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 版改定の判定のバッチ処理です。
 *
 * @reamsid_L DBU-4880-090 wangxiaodong
 */
public class TokuteiKojinJohoTeikyoSetParameterProcess extends SimpleBatchProcessBase {

    private static final RString 時00分00秒00 = new RString("000000");
    private static final int 年最後の月 = 3;
    private static final int 年開始の月 = 4;
    private static final int 年最後の日 = 31;
    private static final int 西暦年最後の月 = 12;
    private static final int 五年 = 5;

    /**
     * 新規異動区分の判定です。
     */
    public static final RString SHINKIIDOKUBUN;

    static {
        SHINKIIDOKUBUN = new RString("shinkiIdoKubun");
    }
    private OutputParameter<ShinkiIdoKubun> shinkiIdoKubun;

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
    private OutputParameter<RenkeisakiDantainaiTogoAtena> renkeisakiDantainaiTogoAtena;

    @Override
    protected void process() {
        RDateTime システム日付 = RDate.getNowDateTime();
        setParameter_新規異動区分();
        setParameter_抽出開始日時(システム日付.getDate());
        setParameter_抽出終了日時(システム日付);
        setParameter_連携先団体内統合宛名(システム日付.getDate());

    }

    private void setParameter_新規異動区分() {
        shinkiIdoKubun = new OutputParameter<>();
        int count_版番号 = getMapper(ITokuteiKojinJohoTeikyoMapper.class)
                .getTokuteiKojinJohoHanKanriCount(ShokaiTeikyoKubun.初回提供済み.getコード());
        if (count_版番号 == 0) {
            shinkiIdoKubun.setValue(ShinkiIdoKubun.当初);
        } else {
            shinkiIdoKubun.setValue(ShinkiIdoKubun.版改定);
        }
    }

    private void setParameter_抽出開始日時(RDate システム日付) {
        taishoKaishiTimestamp = new OutputParameter<>();
        if (年開始の月 <= システム日付.getMonthValue() || システム日付.getMonthValue() <= 西暦年最後の月) {
            taishoKaishiTimestamp.setValue(RDateTime.of(new RDate(システム日付.getMonthValue() + 1, 年最後の月, 年最後の日)
                    .minusYear(五年).toDateString(), 時00分00秒00));
        } else {
            taishoKaishiTimestamp.setValue(RDateTime.of(new RDate(システム日付.getMonthValue(), 年最後の月, 年最後の日)
                    .minusYear(五年).toDateString(), 時00分00秒00));
        }
    }

    private void setParameter_抽出終了日時(RDateTime システム日付) {
        taishoShuryoTimestamp = new OutputParameter<>();
//      TODO 上記「3.1-③」で取得した処理日付管理マスタ（異動用).対象終了日時
//      対象終了日時 = get抽出終了日時(システム日付, システム日付);
        YMDHMS 異動用対象終了日時 = YMDHMS.now();
        if (異動用対象終了日時 == null) {
            taishoShuryoTimestamp.setValue(システム日付);
        } else {
            taishoShuryoTimestamp.setValue(異動用対象終了日時.getRDateTime());
        }
    }

    private void setParameter_連携先団体内統合宛名(RDate システム日付) {
        renkeisakiDantainaiTogoAtena = new OutputParameter<>();
        renkeisakiDantainaiTogoAtena.setValue(RenkeisakiDantainaiTogoAtena.toValue(
                DbBusinessConfig.get(ConfigNameDBU.番号制度_連携先団体内統合宛名_連携方式, システム日付)));
    }

}
