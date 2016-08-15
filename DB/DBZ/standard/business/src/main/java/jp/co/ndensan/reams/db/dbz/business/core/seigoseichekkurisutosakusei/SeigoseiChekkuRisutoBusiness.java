/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.seigoseichekkurisutosakusei;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1014SeigoseiCheckEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuRisutoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.seigoseichekkurisutosakusei.SeigoseiChekkuTempTableBEntity;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.DateOfBirthFactory;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者基本情報の作成クラスです。
 *
 * @reamsid_L DBA-5800-030 zhangzhiming
 */
public final class SeigoseiChekkuRisutoBusiness {

    private static final int 連番 = 65;
    private static final RString コード = new RString("02");
    private static final RString 異動事由コード_24 = new RString("24");
    private static final RString 異動事由コード_22 = new RString("22");
    private static final RString 異動事由コード_20 = new RString("20");
    private static final RString 種別_1 = new RString("1");
    private static final RString 種別_2 = new RString("2");
    private static final RString 種別_3 = new RString("3");

    private SeigoseiChekkuRisutoBusiness() {
    }

    /**
     * 整合性チェック情報一時ファイルBを設定します。
     *
     * @param entity 宛名の入力情報
     * @return 整合性チェック情報一時ファイルB
     */
    public static SeigoseiChekkuTempTableBEntity set整合性チェック情報一時ファイルB(SeigoseiChekkuRisutoEntity entity) {
        SeigoseiChekkuTempTableBEntity tableEntity = new SeigoseiChekkuTempTableBEntity();
        tableEntity.set識別コード(entity.get宛名識別コード());
        tableEntity.set対象外フラグ(entity.is対象外フラグ());
        tableEntity.set不整合理由コード(entity.get不整合理由コード());
        tableEntity.set登録日時(entity.get登録日時());
        tableEntity.set履歴番号(entity.get履歴番号());
        tableEntity.set異動年月日(entity.get異動年月日());
        tableEntity.set届出年月日(entity.get届出年月日());
        tableEntity.set異動事由コード(entity.get異動事由コード());
        tableEntity.set処理事由コード(entity.get処理事由コード());
        tableEntity.set処理年月日(entity.get処理年月日());
        tableEntity.set住民種別コード(entity.get住民種別コード());
        tableEntity.set住民状態コード(entity.get住民状態コード());
        tableEntity.set生年月日(entity.get生年月日());
        tableEntity.set登録事由コード(entity.get登録事由コード());
        tableEntity.set登録異動年月日(entity.get登録異動年月日());
        tableEntity.set登録届出年月日(entity.get登録届出年月日());
        tableEntity.set消除事由コード(entity.get消除事由コード());
        tableEntity.set消除異動年月日(entity.get消除異動年月日());
        tableEntity.set消除届出年月日(entity.get消除届出年月日());
        tableEntity.set消除通知フラグ(entity.is消除通知フラグ());
        tableEntity.set転出予定異動年月日(entity.get転出予定異動年月日());
        tableEntity.set転出確定異動年月日(entity.get転出確定異動年月日());
        tableEntity.set転出確定通知年月日(entity.get転出確定通知年月日());
        tableEntity.set台帳種別(entity.get台帳種別());
        tableEntity.set資格異動日(entity.get資格異動日());
        tableEntity.set資格異動枝番(entity.get資格異動枝番());
        tableEntity.set資格異動事由コード(entity.get資格異動事由コード());
        tableEntity.set被保険者番号(entity.get被保険者番号());
        tableEntity.set市町村コード(entity.get市町村コード());
        tableEntity.set取得適用事由コード(entity.get取得適用事由コード());
        tableEntity.set取得適用年月日(entity.get取得適用年月日());
        tableEntity.set取得適用届出年月日(entity.get取得適用届出年月日());
        tableEntity.set喪失解除事由コード(entity.get喪失解除事由コード());
        tableEntity.set喪失解除年月日(entity.get喪失解除年月日());
        tableEntity.set喪失解除届出年月日(entity.get喪失解除届出年月日());
        tableEntity.set第1号取得年月日(entity.get第1号取得年月日());
        tableEntity.set被保険者区分コード(entity.get被保険者区分コード());
        tableEntity.set資格変更事由コード(entity.get資格変更事由コード());
        tableEntity.set資格変更年月日(entity.get資格変更年月日());
        tableEntity.set資格変更届出年月日(entity.get資格変更届出年月日());
        tableEntity.set住特適用事由コード(entity.get住特適用事由コード());
        tableEntity.set住特適用年月日(entity.get住特適用年月日());
        tableEntity.set住特適用届出年月日(entity.get住特適用届出年月日());
        tableEntity.set住特解除事由コード(entity.get住特解除事由コード());
        tableEntity.set住特解除年月日(entity.get住特解除年月日());
        tableEntity.set住特解除届出年月日(entity.get住特解除届出年月日());
        return tableEntity;
    }

    /**
     * 整合性チェック情報登録を設定します。
     *
     * @param entity 入力情報
     * @return 整合性チェック情報登録
     */
    public static DbT1014SeigoseiCheckEntity set整合性チェック情報登録(SeigoseiChekkuRisutoEntity entity) {
        DbT1014SeigoseiCheckEntity dbt1014Entity = new DbT1014SeigoseiCheckEntity();
        dbt1014Entity.setShikibetsuCode(entity.get宛名識別コード());
        dbt1014Entity.setTaishogaiFlag(entity.is対象外フラグ());
        dbt1014Entity.setFuseigoRiyuCode(entity.get不整合理由コード());
        dbt1014Entity.setTorokuTimestamp(RDateTime.now());
        dbt1014Entity.setRierkiNo(entity.get履歴番号());
        dbt1014Entity.setIdoYMD(entity.get異動年月日());
        dbt1014Entity.setTodokedeYMD(entity.get届出年月日());
        dbt1014Entity.setIdoJiyuCode(entity.get異動事由コード());
        dbt1014Entity.setShoriJiyuCode(entity.get処理事由コード());
        dbt1014Entity.setShoriYMD(entity.get処理年月日());
        dbt1014Entity.setJuminShubetsuCode(entity.get住民種別コード());
        dbt1014Entity.setJuminJotaiCode(entity.get住民状態コード());
        dbt1014Entity.setSeinengappiYMD(entity.get生年月日());
        dbt1014Entity.setTorokuJiyuCode(entity.get登録事由コード());
        dbt1014Entity.setTorokuIdoYMD(entity.get登録異動年月日());
        dbt1014Entity.setTorokuTodokedeYMD(entity.get登録届出年月日());
        dbt1014Entity.setShojoJiyuCode(entity.get消除事由コード());
        dbt1014Entity.setShojoIdoYMD(entity.get消除異動年月日());
        dbt1014Entity.setShojoTodokedeYMD(entity.get消除届出年月日());
        dbt1014Entity.setShojoTsuchiFlag(entity.is消除通知フラグ());
        dbt1014Entity.setTenshutsuYoteiIdoYMD(entity.get転出予定異動年月日());
        dbt1014Entity.setTenshutsuKakuteiIdoYMD(entity.get転出確定異動年月日());
        dbt1014Entity.setTenshutsuKakuteiTsuchiYMD(entity.get転出確定通知年月日());
        dbt1014Entity.setDaichoShubetsu(entity.get台帳種別());
        dbt1014Entity.setShikakuIdoYMD(entity.get資格異動日());
        dbt1014Entity.setShikakuIdoEdaNo(entity.get資格異動枝番());
        dbt1014Entity.setShikakuIdoJiyuCode(entity.get資格異動事由コード());
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            dbt1014Entity.setHihokenshaNo(entity.get被保険者番号());
        }
        dbt1014Entity.setShichosonCode(entity.get市町村コード());
        dbt1014Entity.setShutokuTekiyoJiyuCode(entity.get取得適用事由コード());
        dbt1014Entity.setShutokuTekiyoYMD(entity.get取得適用年月日());
        dbt1014Entity.setShutokuTekiyoTodokedeYMD(entity.get取得適用届出年月日());
        dbt1014Entity.setSoshitsuKaijoJiyuCode(entity.get喪失解除事由コード());
        dbt1014Entity.setSoshitsuKaijoYMD(entity.get喪失解除年月日());
        dbt1014Entity.setSoshitsuKaijoTodokedeYMD(entity.get喪失解除届出年月日());
        dbt1014Entity.setIchigoShutokuYMD(entity.get第1号取得年月日());
        dbt1014Entity.setHihokenshaKubunCode(entity.get被保険者区分コード());
        dbt1014Entity.setShikakuHenkoJiyuCode(entity.get資格変更事由コード());
        dbt1014Entity.setShikakuHenkoYMD(entity.get資格変更年月日());
        dbt1014Entity.setShikakuHenkoTodokedeYMD(entity.get資格変更届出年月日());
        dbt1014Entity.setJutokuTekiyoJiyuCode(entity.get住特適用事由コード());
        dbt1014Entity.setJutokuTekiyoYMD(entity.get住特適用年月日());
        dbt1014Entity.setJutokuTekiyoTodokedeYMD(entity.get住特適用届出年月日());
        dbt1014Entity.setJutokuKaijoJiyuCode(entity.get住特解除事由コード());
        dbt1014Entity.setJutokuKaijoYMD(entity.get住特解除年月日());
        dbt1014Entity.setJutokuKaijoTodokedeYMD(entity.get住特解除届出年月日());
        return dbt1014Entity;
    }

    /**
     * 整合性チェック情報一時ファイルDを設定します。
     *
     * @param entity 宛名の入力情報
     * @return 整合性チェック情報一時ファイルD
     */
    public static SeigoseiChekkuTempTableBEntity set整合性チェック情報一時ファイルD(SeigoseiChekkuRisutoEntity entity) {
        FlexibleDate 比較解除年月日 = entity.get比較解除年月日();
        if (entity.get比較解除年月日() == null || entity.get比較解除年月日().isEmpty()) {
            比較解除年月日 = new FlexibleDate("99991231");
        }
        if (entity.get宛名識別コード() == null || entity.get宛名識別コード().isEmpty()) {
            return set宛名なし情報(entity);
        }
        if (entity.get生年月日() == null || entity.get生年月日().isEmpty() || !entity.get生年月日().isValid()) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("01"));
            return tableEntity;
        }
        AgeCalculator ac = new AgeCalculator(DateOfBirthFactory.createInstance(entity.get生年月日()),
                JuminJotai.toValue(entity.get住民状態コード()), entity.get消除異動年月日());
        FlexibleDate 年齢到達日 = ac.get年齢到達日(連番);
        if (!(コード.equals(entity.get取得事由コード()) && 年齢到達日.equals(entity.get資格異動日()))
                && FlexibleDate.getNowDate().isBefore(年齢到達日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("03"));
            return tableEntity;
        }
        if (種別_1.equals(entity.get台帳種別()) && 異動事由コード_24.equals(entity.get異動事由コード())
                && FlexibleDate.getNowDate().isBefore(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("21"));
            return tableEntity;
        }
        if (種別_1.equals(entity.get台帳種別()) && 異動事由コード_20.equals(entity.get異動事由コード())
                && FlexibleDate.getNowDate().isBefore(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(異動事由コード_22);
            return tableEntity;
        }
        return setチェック判定(entity, 比較解除年月日);
    }

    private static SeigoseiChekkuTempTableBEntity setチェック判定(SeigoseiChekkuRisutoEntity entity, FlexibleDate 比較解除年月日) {
        if (種別_1.equals(entity.get台帳種別()) && 異動事由コード_22.equals(entity.get異動事由コード())
                && FlexibleDate.getNowDate().isBefore(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("23"));
            return tableEntity;
        }
        if (種別_1.equals(entity.get台帳種別()) && 種別_1.equals(entity.get住民状態コード())
                && 比較解除年月日.isBefore(FlexibleDate.getNowDate())) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("04"));
            return tableEntity;
        }
        if (種別_1.equals(entity.get台帳種別()) && entity.get消除異動年月日() != null && !entity.get消除異動年月日().isEmpty()
                && !entity.get消除異動年月日().plusDay(1).equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("31"));
            return tableEntity;
        }
        if (種別_2.equals(entity.get台帳種別()) && entity.get消除異動年月日() != null && !entity.get消除異動年月日().isEmpty()
                && !entity.get消除異動年月日().plusDay(1).equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("52"));
            return tableEntity;
        }
        if (種別_3.equals(entity.get台帳種別()) && entity.get消除異動年月日() != null && !entity.get消除異動年月日().isEmpty()
                && !entity.get消除異動年月日().plusDay(1).equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("62"));
            return tableEntity;
        }
        return setチェック判定2(entity, 比較解除年月日);

    }

    private static SeigoseiChekkuTempTableBEntity setチェック判定2(SeigoseiChekkuRisutoEntity entity, FlexibleDate 比較解除年月日) {
        if (種別_1.equals(entity.get台帳種別()) && entity.get転出予定異動年月日() != null && !entity.get転出予定異動年月日().isEmpty()
                && !entity.get転出予定異動年月日().plusDay(1).equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("32"));
            return tableEntity;
        }
        if (種別_2.equals(entity.get台帳種別()) && entity.get転出予定異動年月日() != null && !entity.get転出予定異動年月日().isEmpty()
                && !entity.get転出予定異動年月日().plusDay(1).equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("53"));
            return tableEntity;
        }
        if (種別_3.equals(entity.get台帳種別()) && entity.get転出予定異動年月日() != null && !entity.get転出予定異動年月日().isEmpty()
                && !entity.get転出予定異動年月日().plusDay(1).equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("63"));
            return tableEntity;
        }
        if (種別_1.equals(entity.get台帳種別()) && entity.get転出確定異動年月日() != null && !entity.get転出確定異動年月日().isEmpty()
                && !entity.get転出確定異動年月日().equals(比較解除年月日)) {
            SeigoseiChekkuTempTableBEntity tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("33"));
            return tableEntity;
        }
        return setチェック判定3(entity, 比較解除年月日);
    }

    private static SeigoseiChekkuTempTableBEntity setチェック判定3(SeigoseiChekkuRisutoEntity entity, FlexibleDate 比較解除年月日) {
        SeigoseiChekkuTempTableBEntity tableEntity = new SeigoseiChekkuTempTableBEntity();
        if (種別_2.equals(entity.get台帳種別()) && entity.get転出確定異動年月日() != null && !entity.get転出確定異動年月日().isEmpty()
                && !entity.get転出確定異動年月日().equals(比較解除年月日)) {
            tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("54"));
        }
        if (種別_3.equals(entity.get台帳種別()) && entity.get転出確定異動年月日() != null && !entity.get転出確定異動年月日().isEmpty()
                && !entity.get転出確定異動年月日().equals(比較解除年月日)) {
            tableEntity = set宛名なし情報(entity);
            tableEntity.set不整合理由コード(new RString("64"));
        }
        return tableEntity;
    }

    private static SeigoseiChekkuTempTableBEntity set宛名なし情報(SeigoseiChekkuRisutoEntity entity) {
        SeigoseiChekkuTempTableBEntity tableEntity = new SeigoseiChekkuTempTableBEntity();
        tableEntity.set識別コード(entity.get台帳識別コード());
        if (entity.get宛名識別コード() != null && !entity.get宛名識別コード().isEmpty()) {
            tableEntity.set対象外フラグ(entity.is対象外フラグ());
            tableEntity.set登録日時(entity.get登録日時());
            tableEntity.set履歴番号(entity.get履歴番号());
            tableEntity.set異動年月日(entity.get異動年月日());
            tableEntity.set届出年月日(entity.get届出年月日());
            tableEntity.set異動事由コード(entity.get異動事由コード());
            tableEntity.set処理事由コード(entity.get処理事由コード());
            tableEntity.set処理年月日(entity.get処理年月日());
            tableEntity.set住民種別コード(entity.get住民種別コード());
            tableEntity.set住民状態コード(entity.get住民状態コード());
            tableEntity.set生年月日(entity.get生年月日());
            tableEntity.set登録事由コード(entity.get登録事由コード());
            tableEntity.set登録異動年月日(entity.get登録異動年月日());
            tableEntity.set登録届出年月日(entity.get登録届出年月日());
            tableEntity.set消除事由コード(entity.get消除事由コード());
            tableEntity.set消除異動年月日(entity.get消除異動年月日());
            tableEntity.set消除届出年月日(entity.get消除届出年月日());
            tableEntity.set消除通知フラグ(entity.is消除通知フラグ());
            tableEntity.set転出予定異動年月日(entity.get転出予定異動年月日());
            tableEntity.set転出確定異動年月日(entity.get転出確定異動年月日());
            tableEntity.set転出確定通知年月日(entity.get転出確定通知年月日());
        } else {
            tableEntity.set対象外フラグ(false);
            tableEntity.set不整合理由コード(コード);
            tableEntity.set登録日時(new RString(FlexibleDate.getNowDate().toString()));
            tableEntity.set異動年月日(null);
            tableEntity.set届出年月日(null);
            tableEntity.set異動事由コード(RString.EMPTY);
            tableEntity.set処理事由コード(RString.EMPTY);
            tableEntity.set処理年月日(null);
            tableEntity.set住民種別コード(RString.EMPTY);
            tableEntity.set住民状態コード(RString.EMPTY);
            tableEntity.set生年月日(null);
            tableEntity.set登録事由コード(RString.EMPTY);
            tableEntity.set登録異動年月日(null);
            tableEntity.set登録届出年月日(null);
            tableEntity.set消除事由コード(RString.EMPTY);
            tableEntity.set消除異動年月日(null);
            tableEntity.set消除届出年月日(null);
            tableEntity.set消除通知フラグ(false);
            tableEntity.set転出予定異動年月日(null);
            tableEntity.set転出確定異動年月日(null);
            tableEntity.set転出確定通知年月日(null);
        }
        tableEntity.set台帳種別(entity.get台帳種別());
        tableEntity.set資格異動日(entity.get資格異動日());
        tableEntity.set資格異動枝番(entity.get資格異動枝番());
        tableEntity.set資格異動事由コード(entity.get資格異動事由コード());
        tableEntity.set被保険者番号(entity.get被保険者番号());
        tableEntity.set市町村コード(entity.get市町村コード());
        tableEntity.set取得適用事由コード(entity.get取得適用事由コード());
        tableEntity.set取得適用年月日(entity.get取得適用年月日());
        tableEntity.set取得適用届出年月日(entity.get取得適用届出年月日());
        tableEntity.set喪失解除事由コード(entity.get喪失解除事由コード());
        tableEntity.set喪失解除年月日(entity.get喪失解除年月日());
        tableEntity.set喪失解除届出年月日(entity.get喪失解除届出年月日());
        tableEntity.set第1号取得年月日(entity.get第1号取得年月日());
        tableEntity.set被保険者区分コード(entity.get被保険者区分コード());
        tableEntity.set資格変更事由コード(entity.get資格変更事由コード());
        tableEntity.set資格変更年月日(entity.get資格変更年月日());
        tableEntity.set資格変更届出年月日(entity.get資格変更届出年月日());
        tableEntity.set住特適用事由コード(entity.get住特適用事由コード());
        tableEntity.set住特適用年月日(entity.get住特適用年月日());
        tableEntity.set住特適用届出年月日(entity.get住特適用届出年月日());
        tableEntity.set住特解除事由コード(entity.get住特解除事由コード());
        tableEntity.set住特解除年月日(entity.get住特解除年月日());
        tableEntity.set住特解除届出年月日(entity.get住特解除届出年月日());
        return tableEntity;
    }

    /**
     * 整合性チェック情報登録を設定します。
     *
     * @param entity 入力情報
     * @return 整合性チェック情報登録
     */
    public static DbT1014SeigoseiCheckEntity set整合性チェック情報登録D(SeigoseiChekkuRisutoEntity entity) {
        DbT1014SeigoseiCheckEntity dbt1014Entity = new DbT1014SeigoseiCheckEntity();
        dbt1014Entity.setShikibetsuCode(entity.get台帳識別コード());
        dbt1014Entity.setTaishogaiFlag(entity.is対象外フラグ());
        dbt1014Entity.setFuseigoRiyuCode(entity.get不整合理由コード());
        dbt1014Entity.setTorokuTimestamp(RDateTime.now());
        dbt1014Entity.setRierkiNo(entity.get履歴番号());
        dbt1014Entity.setIdoYMD(entity.get異動年月日());
        dbt1014Entity.setTodokedeYMD(entity.get届出年月日());
        dbt1014Entity.setIdoJiyuCode(entity.get異動事由コード());
        dbt1014Entity.setShoriJiyuCode(entity.get処理事由コード());
        dbt1014Entity.setShoriYMD(entity.get処理年月日());
        dbt1014Entity.setJuminShubetsuCode(entity.get住民種別コード());
        dbt1014Entity.setJuminJotaiCode(entity.get住民状態コード());
        dbt1014Entity.setSeinengappiYMD(entity.get生年月日());
        dbt1014Entity.setTorokuJiyuCode(entity.get登録事由コード());
        dbt1014Entity.setTorokuIdoYMD(entity.get登録異動年月日());
        dbt1014Entity.setTorokuTodokedeYMD(entity.get登録届出年月日());
        dbt1014Entity.setShojoJiyuCode(entity.get消除事由コード());
        dbt1014Entity.setShojoIdoYMD(entity.get消除異動年月日());
        dbt1014Entity.setShojoTodokedeYMD(entity.get消除届出年月日());
        dbt1014Entity.setShojoTsuchiFlag(entity.is消除通知フラグ());
        dbt1014Entity.setTenshutsuYoteiIdoYMD(entity.get転出予定異動年月日());
        dbt1014Entity.setTenshutsuKakuteiIdoYMD(entity.get転出確定異動年月日());
        dbt1014Entity.setTenshutsuKakuteiTsuchiYMD(entity.get転出確定通知年月日());
        dbt1014Entity.setDaichoShubetsu(entity.get台帳種別());
        dbt1014Entity.setShikakuIdoYMD(entity.get資格異動日());
        dbt1014Entity.setShikakuIdoEdaNo(entity.get資格異動枝番());
        dbt1014Entity.setShikakuIdoJiyuCode(entity.get資格異動事由コード());
        if (entity.get被保険者番号() != null && !entity.get被保険者番号().isEmpty()) {
            dbt1014Entity.setHihokenshaNo(entity.get被保険者番号());
        }
        dbt1014Entity.setShichosonCode(entity.get市町村コード());
        dbt1014Entity.setShutokuTekiyoJiyuCode(entity.get取得適用事由コード());
        dbt1014Entity.setShutokuTekiyoYMD(entity.get取得適用年月日());
        dbt1014Entity.setShutokuTekiyoTodokedeYMD(entity.get取得適用届出年月日());
        dbt1014Entity.setSoshitsuKaijoJiyuCode(entity.get喪失解除事由コード());
        dbt1014Entity.setSoshitsuKaijoYMD(entity.get喪失解除年月日());
        dbt1014Entity.setSoshitsuKaijoTodokedeYMD(entity.get喪失解除届出年月日());
        dbt1014Entity.setIchigoShutokuYMD(entity.get第1号取得年月日());
        dbt1014Entity.setHihokenshaKubunCode(entity.get被保険者区分コード());
        dbt1014Entity.setShikakuHenkoJiyuCode(entity.get資格変更事由コード());
        dbt1014Entity.setShikakuHenkoYMD(entity.get資格変更年月日());
        dbt1014Entity.setShikakuHenkoTodokedeYMD(entity.get資格変更届出年月日());
        dbt1014Entity.setJutokuTekiyoJiyuCode(entity.get住特適用事由コード());
        dbt1014Entity.setJutokuTekiyoYMD(entity.get住特適用年月日());
        dbt1014Entity.setJutokuTekiyoTodokedeYMD(entity.get住特適用届出年月日());
        dbt1014Entity.setJutokuKaijoJiyuCode(entity.get住特解除事由コード());
        dbt1014Entity.setJutokuKaijoYMD(entity.get住特解除年月日());
        dbt1014Entity.setJutokuKaijoTodokedeYMD(entity.get住特解除届出年月日());
        return dbt1014Entity;
    }
}
