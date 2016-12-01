/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;

/**
 * 住所地特例者情報のバッチ処理です。
 *
 * @reamsid_L DBU-4880-040 linghuhang
 */
public class JogaiTokureiSyaJyohouProcess extends BatchProcessBase<JogaiTokureiSyaJyohouRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString("jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.tokuteikojinjohoteikyo."
            + "IJogaiTokureiSyaJyohouMapper.get当初_版改定_異動分データ");
    private static final int 翌日 = 1;
    private static final int INT_ZERO = 0;
    private static final int 年 = 2000;
    private static final int 月 = 4;
    private static final int 日 = 1;
    private static final RString 該当項目 = new RString("NotAcceptable");
    private static final RString 保有 = new RString("NotCovered");
    private JogaiTokureiSyaJyohouProcessParameter processParameter;
    private JogaiTokureiSyaJyohouMybatisParameter mybatisParameter;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;

    @Override
    protected void initialize() {
        RString 新規異動区分 = processParameter.get新規異動区分();
        RDateTime 対象開始日時 = processParameter.get対象開始日時();
        if (対象開始日時 == null) {
            対象開始日時 = RDateTime.of(年, 月, 日, INT_ZERO, INT_ZERO);
        }
        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        FlexibleDate 事業所抽出開始年月日 = FlexibleDate.EMPTY;
        FlexibleDate 事業所抽出終了年月日 = FlexibleDate.EMPTY;
        if (ShinkiIdoKubun.再登録.getコード().equals(新規異動区分)
                || ShinkiIdoKubun.異動.getコード().equals(新規異動区分)) {
            事業所抽出開始年月日 = new FlexibleDate(対象開始日時.getDate().plusDay(翌日).toDateString());
            if (システム日付.isBefore(事業所抽出開始年月日)) {
                事業所抽出開始年月日 = システム日付;
                事業所抽出終了年月日 = new FlexibleDate(対象開始日時.getDate().plusDay(翌日).toDateString());
            } else {
                事業所抽出終了年月日 = システム日付;
            }
        }
        mybatisParameter = JogaiTokureiSyaJyohouMybatisParameter.createParamter当初_版改定_異動分データ抽出(
                事業所抽出開始年月日, 事業所抽出終了年月日,
                processParameter.get対象開始日時(), processParameter.get対象終了日時(),
                processParameter.get個人番号付替対象者被保険者番号(),
                processParameter.get版番号(),
                新規異動区分,
                RString.EMPTY,
                RString.EMPTY);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(processParameter.get提供基本情報中間テーブル名(),
                TeikyoKihonJohoNNTempEntity.class);
    }

    @Override
    protected void process(JogaiTokureiSyaJyohouRelateEntity entity) {
        中間DB提供基本情報.insert(getTeikyoKihonJohoEntity(entity));
    }

    private TeikyoKihonJohoNNTempEntity getTeikyoKihonJohoEntity(JogaiTokureiSyaJyohouRelateEntity relateEntity) {
        TeikyoKihonJohoNNTempEntity entity = new TeikyoKihonJohoNNTempEntity();
        entity.setHihokenshaNo(relateEntity.getHihokenshaNo());
        entity.setDataSetKey(getデータセットキー(relateEntity.getHihokenshaNo(), relateEntity.getShikakuShutokuYMD()));
        entity.setTeikyoKubun(RString.EMPTY);
        entity.setShikibetsuCode(relateEntity.getShikibetsuCode());
        entity.setKojinNo(RString.EMPTY);
        entity.setTokuteiKojinJohoMeiCode(TokuteiKojinJohomeiCode.特定個人情報版管理番号04.getコード());
        entity.setHanNo(processParameter.get版番号());
        entity.setTeikyoNaiyo01(relateEntity.getJigyoshaJusho());
        entity.setMisetteiJiyu01(get未設定事由(relateEntity.getJigyoshaJusho()));
        entity.setTeikyoNaiyo02(get事業者名称(relateEntity.getJigyoshaMeisho()));
        entity.setMisetteiJiyu02(get未設定事由(get事業者名称(
                relateEntity.getJigyoshaMeisho())));
        entity.setTeikyoNaiyo03(get日期(relateEntity.getNyushoYMD()));
        entity.setMisetteiJiyu03(get未設定事由(get日期(relateEntity.getNyushoYMD())));
        entity.setTeikyoNaiyo04(RString.EMPTY);
        entity.setMisetteiJiyu04(保有);
        entity.setTeikyoNaiyo05(get日期(relateEntity.getTaishoYMD()));
        entity.setMisetteiJiyu05(get未設定事由(get日期(relateEntity.getTaishoYMD())));
        entity.setTeikyoNaiyo06(get施設電話番号(relateEntity.getTelNo()));
        entity.setMisetteiJiyu06(get未設定事由(
                get施設電話番号(relateEntity.getTelNo())));
        entity.setTeikyoNaiyo07(RString.EMPTY);
        entity.setMisetteiJiyu07(RString.EMPTY);
        entity.setTeikyoNaiyo08(RString.EMPTY);
        entity.setMisetteiJiyu08(RString.EMPTY);
        entity.setTeikyoNaiyo09(RString.EMPTY);
        entity.setMisetteiJiyu09(RString.EMPTY);
        entity.setTeikyoNaiyo10(RString.EMPTY);
        entity.setMisetteiJiyu10(RString.EMPTY);
        entity.setKokaiYMD(new FlexibleDate(RDate.getNowDate().toDateString()));
        return entity;
    }

    private RString getデータセットキー(HihokenshaNo 被保険者番号, FlexibleDate 資格取得年月日) {
        RStringBuilder データセットキー = new RStringBuilder();
        if (被保険者番号 != null && !被保険者番号.isEmpty()) {
            データセットキー.append(被保険者番号.value());
        }
        データセットキー.append(DataSetNo._0102住所地特例情報.getコード());
        if (資格取得年月日 != null && !資格取得年月日.isEmpty()) {
            データセットキー.append(資格取得年月日.toString());
        }
        return データセットキー.toRString();
    }

    private RString get日期(FlexibleDate 年月日) {
        if (年月日 != null && !年月日.isEmpty()) {
            return new RString(年月日.toString());
        }
        return RString.EMPTY;
    }

    private RString get事業者名称(AtenaMeisho 事業者名称) {
        if (事業者名称 != null && !事業者名称.isEmpty()) {
            return 事業者名称.value();
        }
        return RString.EMPTY;
    }

    private RString get施設電話番号(TelNo 施設電話番号) {
        if (施設電話番号 != null && !施設電話番号.isEmpty()) {
            return 施設電話番号.value();
        }
        return RString.EMPTY;
    }

    private RString get未設定事由(RString 提供内容) {
        if (RString.isNullOrEmpty(提供内容)) {
            return 該当項目;
        }
        return RString.EMPTY;
    }
}
