/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU080010;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.core.tokuteikojinjohoteikyo.TokuteiKojinHanKanriTokuteiJohoBusiness;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.DataSetNo;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShinkiIdoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.ShokaiTeikyoKubun;
import jp.co.ndensan.reams.db.dbu.definition.core.bangoseido.TokuteiKojinJohomeiCode;
import jp.co.ndensan.reams.db.dbu.definition.mybatisprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouMybatisParameter;
import jp.co.ndensan.reams.db.dbu.definition.processprm.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouProcessParameter;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.sougoujigyoujyohou.TeikyoKihonJohoEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.JogaiTokureiSyaJyohouRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.tokuteikojinjohoteikyo.TeikyoKihonJohoNNTempEntity;
import jp.co.ndensan.reams.db.dbu.service.core.tokuteikojinjohoteikyo.TokuteiKojinJohoTeikyoManager;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.batch.BatchInterruptedException;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchEntityCreatedTempTableWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
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
    private static final RString TABLE_中間DB提供基本情報 = new RString("TeikyoKihonJoho");
    private JogaiTokureiSyaJyohouProcessParameter processParameter;
    private JogaiTokureiSyaJyohouMybatisParameter mybatisParameter;
    private List<TokuteiKojinHanKanriTokuteiJohoBusiness> 特定個人版管理特定情報;
    @BatchWriter
    BatchEntityCreatedTempTableWriter 中間DB提供基本情報;

    @Override
    protected void initialize() {
        // TODO 凌護行　パラメータの設定が不明、QA回答まち、2016/10/20
        // 2.1　画面起動時（ワークフローID = xxxxxx）、画面指定内容のチェック
        特定個人版管理特定情報 = new ArrayList<>();
        RString 新規異動区分 = processParameter.get新規異動区分();
        RDateTime 対象開始日時 = processParameter.get対象開始日時();
        FlexibleDate システム日付 = new FlexibleDate(RDate.getNowDate().toDateString());
        FlexibleDate 事業所抽出開始年月日 = FlexibleDate.EMPTY;
        FlexibleDate 事業所抽出終了年月日 = FlexibleDate.EMPTY;
        // TODO 凌護行　パラメータの設定が不明、QA回答まち、2016/10/20
        特定個人版管理特定情報 = TokuteiKojinJohoTeikyoManager.createInstance().get版番号(新規異動区分,
                processParameter.get提供要否List().get(0), DataSetNo._0102住所地特例情報.getコード(), システム日付);
        if ((ShinkiIdoKubun.当初.getコード().equals(新規異動区分)
                || ShinkiIdoKubun.版改定.getコード().equals(新規異動区分))
                && 特定個人版管理特定情報 != null && !特定個人版管理特定情報.isEmpty()
                && ShokaiTeikyoKubun.初回提供済み.getコード().equals(特定個人版管理特定情報.get(0).get初回提供区分())) {
            throw new BatchInterruptedException("");
        }
        if ((ShinkiIdoKubun.再登録.getコード().equals(processParameter.get新規異動区分())
                || ShinkiIdoKubun.異動.getコード().equals(processParameter.get新規異動区分()))
                && 特定個人版管理特定情報 != null && !特定個人版管理特定情報.isEmpty()
                && ShokaiTeikyoKubun.未提供.getコード().equals(特定個人版管理特定情報.get(0).get初回提供区分())) {
            throw new BatchInterruptedException("");
        }
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
                特定個人版管理特定情報.get(0).get版番号(),
                新規異動区分);
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, mybatisParameter);
    }

    @Override
    protected void createWriter() {
        中間DB提供基本情報 = new BatchEntityCreatedTempTableWriter(TABLE_中間DB提供基本情報,
                TeikyoKihonJohoEntity.class);
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
        entity.setHanNo(特定個人版管理特定情報.get(0).get版番号());
        entity.setTeikyoNaiyo01(relateEntity.getJigyoshaJusho());
        // TODO 凌護行　パラメータの設定が不明、QA回答まち、2016/10/20
        entity.setMisetteiJiyu01(RString.EMPTY);
        entity.setTeikyoNaiyo02(get事業者名称(relateEntity.getJigyoshaMeisho()));
        entity.setMisetteiJiyu02(RString.EMPTY);
        entity.setTeikyoNaiyo03(get日期(relateEntity.getNyushoYMD()));
        entity.setMisetteiJiyu03(RString.EMPTY);
        entity.setTeikyoNaiyo04(RString.EMPTY);
        entity.setMisetteiJiyu04(RString.EMPTY);
        entity.setTeikyoNaiyo05(get日期(relateEntity.getTaishoYMD()));
        entity.setMisetteiJiyu05(RString.EMPTY);
        entity.setTeikyoNaiyo06(RString.EMPTY);
        entity.setMisetteiJiyu06(RString.EMPTY);
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
            データセットキー.append(被保険者番号);
        }
        データセットキー.append(DataSetNo._0102住所地特例情報.getコード());
        if (資格取得年月日 != null && !資格取得年月日.isEmpty()) {
            データセットキー.append(資格取得年月日);
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
}
