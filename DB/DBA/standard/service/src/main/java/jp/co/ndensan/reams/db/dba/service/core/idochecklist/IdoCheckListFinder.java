/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.idochecklist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListParameter;
import jp.co.ndensan.reams.db.dba.business.core.idochecklist.IdoCheckListResult;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA130010.DBA130010_IdoCheckListParameter;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 異動チェックリストのサービスクラスです。
 *
 * @reamsid_L DBA-0530-030 chengsanyuan
 */
public class IdoCheckListFinder {

    private static final RString CHECKED_KEY_KEY0 = new RString("key0");
    private static final RString CHECKED_KEY_KEY1 = new RString("key1");
    private static final RString CHECKED_KEY_KEY2 = new RString("key2");
    private static final RString CHECKED_KEY_KEY3 = new RString("key3");
    private static final RString CHECKED_KEY_KEY4 = new RString("key4");
    private static final int TIME_HOUR_23 = 23;
    private static final int TIME_MINUTE_59 = 59;
    private static final int TIME_SECOND_59 = 59;
    private static final int TIME_MILLIS_999 = 999;

    private final DbT7022ShoriDateKanriDac dac;

    /**
     * コンストラクタです。
     *
     */
    IdoCheckListFinder() {
        this.dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac DbT7022ShoriDateKanriDac
     */
    IdoCheckListFinder(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * {@link IdoCheckListFinder#create}にて生成した{@link IdoCheckListFinder}のインスタンスを返します。
     *
     * @return IdoCheckListFinder
     */
    public static IdoCheckListFinder createInstance() {
        return InstanceProvider.create(IdoCheckListFinder.class);
    }

    /**
     * 前回開始終了日を取得します。
     *
     * @return IdoCheckListResult
     */
    public SearchResult<IdoCheckListResult> getKaisiShuryobi() {
        DbT7022ShoriDateKanriEntity entity = dac.select処理日付管理BYサブ業務コードAND処理名(
                SubGyomuCode.DBA介護資格, new RString("異動チェックリスト"));
        if (entity == null) {
            return SearchResult.of(Collections.<IdoCheckListResult>emptyList(), 0, false);
        }
        List<IdoCheckListResult> idoCheckListResultList = new ArrayList<>();
        idoCheckListResultList.add(new IdoCheckListResult(entity));
        return SearchResult.of(idoCheckListResultList, 0, false);
    }

    /**
     * 異動チェックリスト作成画面入力するデータより、バッチ用パラメータクラスを作成します。
     *
     * @param param 異動チェックリストパラメータ
     * @return DBA130010_IdoCheckListParameter
     *
     */
    public DBA130010_IdoCheckListParameter getIdoCheckListBatchParameter(IdoCheckListParameter param) {

        DBA130010_IdoCheckListParameter retParam = new DBA130010_IdoCheckListParameter();
        if (param.isすべて選択()) {
            retParam.setHihokenshaDaichouFlag(true);
            retParam.setRoreiFukushiNenkinFlag(true);
            retParam.setJushochiTokureiKanriFlag(true);
            retParam.setSeikatsuHogoFlag(true);
            retParam.setTekiyoJogaishaDaichouFlag(true);
        } else {
            boolean 被保険者台帳フラグ = false;
            boolean 他住所地特例者管理フラグ = false;
            boolean 適用除外者台帳フラグ = false;
            boolean 生活保護フラグ = false;
            boolean 老齢福祉年金フラグ = false;
            for (RString key : param.get対象List()) {
                if (CHECKED_KEY_KEY0.equals(key)) {
                    被保険者台帳フラグ = true;
                    continue;
                }
                if (CHECKED_KEY_KEY1.equals(key)) {
                    老齢福祉年金フラグ = true;
                    continue;
                }
                if (CHECKED_KEY_KEY2.equals(key)) {
                    他住所地特例者管理フラグ = true;
                    continue;
                }
                if (CHECKED_KEY_KEY3.equals(key)) {
                    生活保護フラグ = true;
                    continue;
                }
                if (CHECKED_KEY_KEY4.equals(key)) {
                    適用除外者台帳フラグ = true;

                }
            }
            retParam.setHihokenshaDaichouFlag(被保険者台帳フラグ);
            retParam.setRoreiFukushiNenkinFlag(老齢福祉年金フラグ);
            retParam.setJushochiTokureiKanriFlag(他住所地特例者管理フラグ);
            retParam.setSeikatsuHogoFlag(生活保護フラグ);
            retParam.setTekiyoJogaishaDaichouFlag(適用除外者台帳フラグ);
        }
        retParam.setZenkaiKaishi(appendZero(param.get前回開始日時FROM()));
        retParam.setZenkaiShuryo(appendDay(param.get前回終了日時TO()));
        retParam.setKonkaiKaishi(appendZero(param.get今回開始日時FROM()));
        retParam.setKonkaiShuryo(appendDay(param.get今回終了日時TO()));
        retParam.setShuturyokuJunId(param.get出力順ID());

        return retParam;
    }

    private RDateTime appendZero(FlexibleDate formatDate) {
        if (formatDate == null || formatDate.isEmpty()) {
            return null;
        }
        return RDateTime.of(formatDate.getYearValue(), formatDate.getMonthValue(), formatDate.getDayValue(), 0, 0, 0, 0);
    }

    private RDateTime appendDay(FlexibleDate formatDate) {
        if (formatDate == null || formatDate.isEmpty()) {
            return null;
        }
        return RDateTime.of(formatDate.getYearValue(),
                formatDate.getMonthValue(),
                formatDate.getDayValue(),
                TIME_HOUR_23,
                TIME_MINUTE_59,
                TIME_SECOND_59,
                TIME_MILLIS_999);
    }
}
