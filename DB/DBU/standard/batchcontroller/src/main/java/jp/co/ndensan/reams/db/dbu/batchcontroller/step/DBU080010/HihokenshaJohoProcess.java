/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dba.definition.batchprm.hanyolist.hihokenshadaicho.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbu.business.core.basic.TokuteiKojinJohoHanKanri;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ChukanHyojunLayoutKaigoIdoJiyu;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.HihokenshaJohoMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.HihokenshaJohoProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.HihokenshaJohoRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBU;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuHenkoJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuSoshitsuJiyu;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakukubun.ShikakuKubun;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者情報のバッチ処理です。
 *
 * @reamsid_L DBU-4880-030 zhaoyao
 */
public class HihokenshaJohoProcess extends BatchProcessBase<HihokenshaJohoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper."
            + "relate.tokuteikojinjohoteikyo.IHihokenshaJohoMapper.get提供情報_候補");
    private static final RString 未設定事由 = new RString("NotAcceptable");
    private HihokenshaJohoProcessParameter processParameter;
    private HihokenshaJohoMybatisParameter mybitisParamter;
    private RString 特定個人情報名コード;
    private RString 版番号;
    private int 資格履歴番号;
    private HihokenshaJohoRelateEntity 退避レコード;
    private boolean 設定フラグ = true;

    @BatchWriter
    private BatchEntityCreatedTempTableWriter teikyoKihonJohoNNTemp;

    @Override
    protected void initialize() {
        RString 新規異動区分 = processParameter.get新規異動区分();
        TokuteiKojinJohoHanKanri 特定個人情報版管理 = TokuteiKojinJohoTeikyoManager.createInstance()
                .get版番号(新規異動区分, 特定個人情報名コード,
                        DataSetNo._0101被保険者情報.getコード(), FlexibleDate.getNowDate()).get(0);
        版番号 = 特定個人情報版管理.get版番号();
        特定個人情報名コード = 特定個人情報版管理.get特定個人情報名コード();
        HihokenshaNo 個人番号付替対象者被保険者番号 = processParameter.get個人番号付替対象者被保険者番号();
        if (個人番号付替対象者被保険者番号 == null) {
            個人番号付替対象者被保険者番号 = HihokenshaNo.EMPTY;
        }
        mybitisParamter = HihokenshaJohoMybatisParameter.createParamter提供情報_候補(新規異動区分, processParameter.get対象開始日時(),
                processParameter.get対象終了日時(), 個人番号付替対象者被保険者番号.value());

    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybitisParamter);
    }

    @Override
    protected void createWriter() {
        teikyoKihonJohoNNTemp = new BatchEntityCreatedTempTableWriter(
                processParameter.get提供基本情報中間テーブル名(), TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(HihokenshaJohoRelateEntity entity) {
        if (設定フラグ) {
            設定フラグ = false;
            退避レコード = entity;
        } else {
            set退避レコード(entity);
        }
    }

    @Override
    protected void afterExecute() {
        if (!退避レコード.getShikakuShutokuYMD().toString().equals(退避レコード.getShikakuSoshitsuYMD().toString())) {
            資格履歴番号 = 資格履歴番号 + 1;
            set中間DB(退避レコード);
        }
    }

    private void set中間DB(HihokenshaJohoRelateEntity entity) {
        TeikyoKihonJohoNNTempEntity tempEntity = new TeikyoKihonJohoNNTempEntity();
        tempEntity.setHihokenshaNo(entity.getHihokenshaNo());
        tempEntity.setDataSetKey(setデータセットキー(entity));
        tempEntity.setTeikyoKubun(RString.EMPTY);
        tempEntity.setShikibetsuCode(entity.getShikibetsuCode());
        tempEntity.setTokuteiKojinJohoMeiCode(特定個人情報名コード);
        tempEntity.setHanNo(版番号);
        tempEntity.setTeikyoNaiyo01(entity.getHihokenshaNo().value());
        tempEntity.setMisetteiJiyu01(RString.EMPTY);
        tempEntity.setTeikyoNaiyo02(DbBusinessConfig.get(ConfigNameDBU.保険者情報_保険者番号,
                RDate.getNowDate(), SubGyomuCode.DBU介護統計報告));
        tempEntity.setMisetteiJiyu02(RString.EMPTY);
        tempEntity.setTeikyoNaiyo03(get日付(entity.getShikakuShutokuYMD()));
        tempEntity.setMisetteiJiyu03(RString.EMPTY);
        tempEntity.setTeikyoNaiyo04(get日付(entity.getShikakuSoshitsuYMD()));
        tempEntity.setMisetteiJiyu04(get未設定事由(entity.getShikakuSoshitsuYMD()));
        tempEntity.setTeikyoNaiyo05(get資格異動事由コード(entity));
        tempEntity.setMisetteiJiyu05(RString.EMPTY);
        tempEntity.setTeikyoNaiyo06(entity.getHihokennshaKubunCode());
        tempEntity.setMisetteiJiyu06(RString.EMPTY);
        tempEntity.setTeikyoNaiyo07(RString.EMPTY);
        tempEntity.setMisetteiJiyu07(RString.EMPTY);
        tempEntity.setTeikyoNaiyo08(RString.EMPTY);
        tempEntity.setMisetteiJiyu08(RString.EMPTY);
        tempEntity.setTeikyoNaiyo09(RString.EMPTY);
        tempEntity.setMisetteiJiyu09(RString.EMPTY);
        tempEntity.setTeikyoNaiyo10(RString.EMPTY);
        tempEntity.setMisetteiJiyu10(RString.EMPTY);
        tempEntity.setKokaiYMD(FlexibleDate.getNowDate());
        teikyoKihonJohoNNTemp.insert(tempEntity);
    }

    private void set退避レコード(HihokenshaJohoRelateEntity 現レコード) {
        if (ShikakuKubun._１号.getコード().equals(退避レコード.getHihokennshaKubunCode())) {
            set退避レコード１(現レコード);
        }
        if (ShikakuKubun._２号.getコード().equals(退避レコード.getHihokennshaKubunCode())) {
            set退避レコード２(現レコード);
        }
    }

    private void set退避レコード１(HihokenshaJohoRelateEntity 現レコード) {
        if (ShikakuKubun._１号.getコード().equals(現レコード.getHihokennshaKubunCode())) {
            if (!退避レコード.getShikakuShutokuYMD().equals(現レコード.getShikakuShutokuYMD())) {
                set退避レコード１_１(現レコード);
            } else {
                退避レコード = 現レコード;
            }
        }
    }

    private void set退避レコード２(HihokenshaJohoRelateEntity 現レコード) {
        if (!退避レコード.getShikakuShutokuYMD().equals(現レコード.getShikakuShutokuYMD())) {
            資格履歴番号 = 資格履歴番号 + 1;
            set中間DB(退避レコード);
            退避レコード = 現レコード;
        } else {
            set退避レコード２_１(現レコード);
        }
    }

    private void set退避レコード１_１(HihokenshaJohoRelateEntity 現レコード) {
        if (退避レコード.getShikakuShutokuYMD().equals(現レコード.getIchigoShikakuShutokuYMD())) {
            退避レコード = 現レコード;
            退避レコード.setShikakuShutokuYMD(現レコード.getIchigoShikakuShutokuYMD());
            退避レコード.setShikakuSoshitsuJiyuCode(ShikakuShutokuJiyu.年齢到達.getコード());
        }
        if (!退避レコード.getShikakuShutokuYMD().equals(現レコード.getIchigoShikakuShutokuYMD())) {
            if (退避レコード.getShikakuShutokuYMD().equals(現レコード.getShikakuSoshitsuYMD())) {
                退避レコード = 現レコード;
            }
            if (!退避レコード.getShikakuShutokuYMD().equals(現レコード.getShikakuSoshitsuYMD())) {
                資格履歴番号 = 資格履歴番号 + 1;
                set中間DB(退避レコード);
                退避レコード = 現レコード;
            }
        }
    }

    private void set退避レコード２_１(HihokenshaJohoRelateEntity 現レコード) {
        if (ShikakuKubun._１号.getコード().equals(現レコード.getHihokennshaKubunCode())) {
            退避レコード.setShikakuSoshitsuYMD(現レコード.getIchigoShikakuShutokuYMD());
            退避レコード.setShikakuSoshitsuJiyuCode(ShikakuHenkoJiyu._１号到達.getコード());
            資格履歴番号 = 資格履歴番号 + 1;
            set中間DB(退避レコード);
            退避レコード = 現レコード;
            退避レコード.setShikakuShutokuYMD(現レコード.getIchigoShikakuShutokuYMD());
            退避レコード.setShikakuSoshitsuJiyuCode(ShikakuShutokuJiyu.年齢到達.getコード());
        }
        if (ShikakuKubun._２号.getコード().equals(現レコード.getHihokennshaKubunCode())) {
            退避レコード = 現レコード;
        }
    }

    private RString get資格異動事由コード(HihokenshaJohoRelateEntity entity) {
        RString 資格取得事由コード = entity.getShikakuShutokuJiyuCode();
        RString 資格喪失事由コード = entity.getShikakuSoshitsuJiyuCode();
        RString 資格異動事由コード = RString.EMPTY;
        if (資格喪失事由コード == null || 資格喪失事由コード.isEmpty()) {
            if (ShikakuShutokuJiyu.転入.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.転入.getコード();
            } else if (ShikakuShutokuJiyu.年齢到達.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.年齢到達.getコード();
            } else if (ShikakuShutokuJiyu.外国人.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.入国.getコード();
            } else if (ShikakuShutokuJiyu._２号申請.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu._2号仮申請.getコード();
            } else if (ShikakuShutokuJiyu.他特例居住.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他取得.getコード();
            } else if (ShikakuShutokuJiyu.除外者居住.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他取得.getコード();
            } else if (ShikakuShutokuJiyu.帰化.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.帰化_資格取得.getコード();
            } else if (ShikakuShutokuJiyu.国籍取得.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他取得.getコード();
            } else if (ShikakuShutokuJiyu.職権取得.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.職権取得.getコード();
            } else if (ShikakuShutokuJiyu.施行時取得.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他取得.getコード();
            } else if (ShikakuShutokuJiyu.その他.getコード().equals(資格取得事由コード)) {
                資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他取得.getコード();
            }
        } else {
            資格異動事由コード = get資格異動事由コード(資格異動事由コード, entity);
        }
        return 資格異動事由コード;
    }

    private RString get資格異動事由コード(RString 資格異動事由コード, HihokenshaJohoRelateEntity entity) {
        RString 資格喪失事由コード = entity.getShikakuSoshitsuJiyuCode();
        if (ShikakuSoshitsuJiyu.転出.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.転出.getコード();
        } else if (ShikakuSoshitsuJiyu.死亡.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.死亡.getコード();
        } else if (ShikakuSoshitsuJiyu.除外者.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.適用除外.getコード();
        } else if (ShikakuSoshitsuJiyu.自特例解除.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.住所地特例解除.getコード();
        } else if (ShikakuSoshitsuJiyu.国籍喪失.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.国籍喪失.getコード();
        } else if (ShikakuSoshitsuJiyu.他特例者.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他喪失.getコード();
        } else if (ShikakuSoshitsuJiyu.職権喪失.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.職権喪失.getコード();
        } else if (ShikakuSoshitsuJiyu.その他.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu.その他喪失.getコード();
        } else if (ShikakuHenkoJiyu._１号到達.getコード().equals(資格喪失事由コード)) {
            資格異動事由コード = ChukanHyojunLayoutKaigoIdoJiyu._1号被保険者変更.getコード();
        }
        return 資格異動事由コード;
    }

    private RString setデータセットキー(HihokenshaJohoRelateEntity entity) {
        return entity.getHihokenshaNo().value().concat(
                DataSetNo._0101被保険者情報.getコード());
    }

    private RString get未設定事由(FlexibleDate 日付) {
        if (日付 == null || 日付.isEmpty()) {
            return 未設定事由;
        }
        return RString.EMPTY;
    }

    private RString get日付(FlexibleDate 日付) {
        if (日付 != null && !日付.isEmpty()) {
            return 日付.wareki().toDateString();
        }
        return RString.EMPTY;
    }
}
