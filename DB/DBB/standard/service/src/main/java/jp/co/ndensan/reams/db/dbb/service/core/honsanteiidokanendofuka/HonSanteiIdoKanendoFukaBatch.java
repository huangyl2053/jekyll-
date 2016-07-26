/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.honsanteiidokanendofuka.KanendoFukaParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbT2015KeisangoJohoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.basic.DbT2015KeisangoJohoDac;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ShoriDateKanriManager;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.EntityDataState;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 処理日付管理テーブル登録。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class HonSanteiIdoKanendoFukaBatch {

    private final ShoriDateKanriManager manager;
    private final DbT2015KeisangoJohoDac 計算後情報Dac;

    private static final int INT_イチ = 1;
    private static final int INT_ヨ = 4;
    private static final RString 年度内連番_0001 = new RString("0001");

    /**
     * コンストラクタです。
     */
    public HonSanteiIdoKanendoFukaBatch() {
        計算後情報Dac = InstanceProvider.create(DbT2015KeisangoJohoDac.class);
        manager = new ShoriDateKanriManager();
    }

    /**
     * 生成した{@link HonSanteiIdoKanendoFukaBatch}のインスタンスを返します。
     *
     * @return HonSanteiIdoKanendoFukaBatch
     */
    public static HonSanteiIdoKanendoFukaBatch createInstance() {
        return InstanceProvider.create(HonSanteiIdoKanendoFukaBatch.class);
    }

    /**
     * 計算後情報作成前に、計算後情報テーブルに処理名=DBZ介護共通Enum．処理名．過年度賦課のレコードを削除する。
     */
    public void deleteKeisangoJohoTemp() {
        List<DbT2015KeisangoJohoEntity> entityList = 計算後情報Dac.selectBy処理名(ShoriName.過年度賦課.get名称());
        if (entityList == null) {
            return;
        }
        for (DbT2015KeisangoJohoEntity entity : entityList) {
            entity.setState(EntityDataState.Deleted);
            計算後情報Dac.delete(entity);
        }
    }

    /**
     * 処理日付管理テーブル登録メソッドです。
     *
     * @param parameter KanendoFukaParameter
     */
    public void insShoriDateKanri(KanendoFukaParameter parameter) {
        FlexibleYear 調定年度 = parameter.get調定年度();

        ShoriDateKanri 過年度賦課_現年度 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課, ShoriName.過年度賦課.get名称(), 調定年度);
        DbT7022ShoriDateKanriEntity 日付管理entity;
        if (過年度賦課_現年度 == null) {
            FlexibleYear 調定年度minus1 = 調定年度.minusYear(INT_イチ);
            ShoriDateKanri 過年度賦課_前年度 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課, ShoriName.過年度賦課.get名称(), 調定年度minus1);
            ShoriDateKanri 異動賦課_前年度 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課, ShoriName.異動賦課.get名称(), 調定年度minus1);
            日付管理entity = get日付管理(異動賦課_前年度, 過年度賦課_前年度, parameter);
        } else {
            日付管理entity = get過年度賦課entity(過年度賦課_現年度, parameter);
        }
        日付管理entity.setState(EntityDataState.Added);
        manager.save処理日付管理マスタ(new ShoriDateKanri(日付管理entity));
        List<DbT2015KeisangoJohoEntity> 賦課対象 = 計算後情報Dac.select計算後情報(
                調定年度, parameter.get日付関連_年度サイクル(), parameter.getシステム日時(), ShoriName.過年度賦課.get名称());
        if (賦課対象 == null || 賦課対象.isEmpty()) {
            日付管理entity.setShoriName(ShoriName.過年度賦課確定.get名称());
            日付管理entity.setKijunTimestamp(new YMDHMS(日付管理entity.getKijunTimestamp().getRDateTime().plusSeconds(INT_イチ)));
            ShoriDateKanri 過年度賦課確定 = manager.get抽出調定日時(SubGyomuCode.DBB介護賦課, ShoriName.過年度賦課確定.get名称(), 調定年度);
            RString 年度内連番 = 過年度賦課確定 == null ? 年度内連番_0001 : 過年度賦課確定.get年度内連番();
            日付管理entity.setNendoNaiRenban(年度内連番);
            日付管理entity.setState(EntityDataState.Added);
            manager.save処理日付管理マスタ(new ShoriDateKanri(日付管理entity));
        }
    }

    private DbT7022ShoriDateKanriEntity get日付管理(ShoriDateKanri 異動賦課_前年度,
            ShoriDateKanri 過年度賦課_前年度,
            KanendoFukaParameter parameter) {
        DbT7022ShoriDateKanriEntity 日付管理entity = new DbT7022ShoriDateKanriEntity();
        if (異動賦課_前年度 == null && 過年度賦課_前年度 == null) {
            YMDHMS 処理日時 = parameter.getシステム日時();
            FlexibleDate 基準年月日 = new FlexibleDate(処理日時.getDate().toString());

            RDateTime 抽出終了日時 = parameter.get抽出終了日時();
            YMDHMS 対象終了日時 = 抽出終了日時 == null ? null : new YMDHMS(抽出終了日時);
            FlexibleDate 対象終了年月日 = 対象終了日時 == null ? null : new FlexibleDate(対象終了日時.getDate().toString());

            RDateTime 抽出開始日時 = parameter.get抽出開始日時();
            YMDHMS 対象開始日時 = 抽出開始日時 == null ? null : new YMDHMS(抽出開始日時);
            FlexibleDate 対象開始年月日 = 抽出開始日時 == null ? null : new FlexibleDate(抽出開始日時.getDate().toString());

            ShoriDateKanri 過年度賦課_DBB = manager.get抽出サブ業務コード(SubGyomuCode.DBB介護賦課);
            日付管理entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
            日付管理entity.setShichosonCode(過年度賦課_DBB.get市町村コード());
            日付管理entity.setShoriName(ShoriName.過年度賦課.get名称());
            日付管理entity.setShoriEdaban(年度内連番_0001);
            日付管理entity.setNendo(parameter.get賦課年度());
            日付管理entity.setNendoNaiRenban(年度内連番_0001);
            日付管理entity.setKijunYMD(基準年月日);
            日付管理entity.setKijunTimestamp(処理日時);
            日付管理entity.setTaishoKaishiYMD(対象開始年月日);
            日付管理entity.setTaishoShuryoYMD(対象終了年月日);
            日付管理entity.setTaishoKaishiTimestamp(対象開始日時);
            日付管理entity.setTaishoShuryoTimestamp(対象終了日時);
        } else if (異動賦課_前年度 != null && 過年度賦課_前年度 == null) {
            日付管理entity = get過年度賦課entity_初回(異動賦課_前年度, parameter);
        } else if (異動賦課_前年度 == null && 過年度賦課_前年度 != null) {
            日付管理entity = get過年度賦課entity_初回(過年度賦課_前年度, parameter);
        } else if (異動賦課_前年度 != null && 過年度賦課_前年度 != null) {
            YMDHMS 異動賦課_終了日時 = 異動賦課_前年度.get対象終了日時();
            YMDHMS 過年度賦課_終了日時 = 過年度賦課_前年度.get対象終了日時();
            if (異動賦課_終了日時 != null && 過年度賦課_終了日時 != null && 異動賦課_終了日時.isBefore(過年度賦課_終了日時)) {
                日付管理entity = get過年度賦課entity_初回(異動賦課_前年度, parameter);
            } else {
                日付管理entity = get過年度賦課entity_初回(過年度賦課_前年度, parameter);
            }
        }
        return 日付管理entity;
    }

    private DbT7022ShoriDateKanriEntity get過年度賦課entity(ShoriDateKanri 過年度賦課_現年度, KanendoFukaParameter parameter) {
        YMDHMS 基準日時 = parameter.getシステム日時();
        RDateTime 対象終了日時 = parameter.get抽出終了日時();
        YMDHMS 抽出終了日時 = 対象終了日時 == null ? null : new YMDHMS(対象終了日時);

        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(過年度賦課_現年度.getサブ業務コード());
        entity.setShichosonCode(過年度賦課_現年度.get市町村コード());
        entity.setShoriName(過年度賦課_現年度.get処理名());
        entity.setShoriEdaban(過年度賦課_現年度.get処理枝番());
        entity.setNendo(過年度賦課_現年度.get年度());
        entity.setNendoNaiRenban(new RString(Integer.valueOf(過年度賦課_現年度.get年度内連番().toString()) + INT_イチ).padZeroToLeft(INT_ヨ));
        entity.setKijunYMD(過年度賦課_現年度.get基準年月日());
        entity.setKijunTimestamp(基準日時);
        entity.setTaishoKaishiYMD(過年度賦課_現年度.get対象開始年月日());
        entity.setTaishoShuryoYMD(過年度賦課_現年度.get対象終了年月日());
        entity.setTaishoKaishiTimestamp(過年度賦課_現年度.get対象開始日時());
        entity.setTaishoShuryoTimestamp(抽出終了日時);
        return entity;
    }

    private DbT7022ShoriDateKanriEntity get過年度賦課entity_初回(ShoriDateKanri 日付管理, KanendoFukaParameter parameter) {
        YMDHMS 処理日時 = parameter.getシステム日時();
        FlexibleDate 基準年月日 = new FlexibleDate(処理日時.getDate().toString());

        RDateTime 抽出終了日時 = parameter.get抽出終了日時();
        YMDHMS 対象終了日時 = 抽出終了日時 == null ? null : new YMDHMS(抽出終了日時);
        FlexibleDate 対象終了年月日 = 対象終了日時 == null ? null : new FlexibleDate(対象終了日時.getDate().toString());

        RDateTime 抽出開始日時 = parameter.get抽出開始日時();
        YMDHMS 対象開始日時 = 抽出開始日時 == null ? null : new YMDHMS(抽出開始日時);
        FlexibleDate 対象開始年月日 = 抽出開始日時 == null ? null : new FlexibleDate(抽出開始日時.getDate().toString());

        DbT7022ShoriDateKanriEntity entity = new DbT7022ShoriDateKanriEntity();
        entity.setSubGyomuCode(SubGyomuCode.DBB介護賦課);
        entity.setShichosonCode(日付管理.get市町村コード());
        entity.setShoriName(ShoriName.過年度賦課.get名称());
        entity.setShoriEdaban(日付管理.get処理枝番());
        entity.setNendo(parameter.get賦課年度());
        entity.setNendoNaiRenban(年度内連番_0001);
        entity.setKijunYMD(基準年月日);
        entity.setKijunTimestamp(処理日時);
        entity.setTaishoKaishiYMD(対象開始年月日);
        entity.setTaishoShuryoYMD(対象終了年月日);
        entity.setTaishoKaishiTimestamp(対象開始日時);
        entity.setTaishoShuryoTimestamp(対象終了日時);
        return entity;
    }

}
