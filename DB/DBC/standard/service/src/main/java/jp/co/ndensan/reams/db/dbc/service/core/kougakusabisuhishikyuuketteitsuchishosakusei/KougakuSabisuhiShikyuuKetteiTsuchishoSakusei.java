/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.kougakusabisuhishikyuuketteitsuchishosakusei;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.ketteitsuchishosakusei.param.KogakuJigyoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020030.DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.dbc020060.DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBCMN43002_高額サービス費支給決定通知書作成（画面）のビジネスクラスです。
 *
 * @reamsid_L DBC-2000-120 chenhui
 */
public class KougakuSabisuhiShikyuuKetteiTsuchishoSakusei {

    private final DbT7022ShoriDateKanriDac dbt7022Dac;

    /**
     * コンストラクタです。
     */
    KougakuSabisuhiShikyuuKetteiTsuchishoSakusei() {
        this.dbt7022Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * にて生成した{@link KougakuSabisuhiShikyuuKetteiTsuchishoSakusei}のインスタンスを返します。
     *
     * @return TokuchoHeijunkaKakutei
     */
    public static KougakuSabisuhiShikyuuKetteiTsuchishoSakusei createInstance() {
        return InstanceProvider.create(KougakuSabisuhiShikyuuKetteiTsuchishoSakusei.class);
    }

    /**
     * 前回対象日のデータの取得のメソッドです。
     *
     * @param 市町村コード LasdecCode
     *
     * @return List<ShoriDateKanri>
     *
     */
    public List<ShoriDateKanri> getZenkaiTaisyobiData(LasdecCode 市町村コード) {
        List<DbT7022ShoriDateKanriEntity> entityList = dbt7022Dac.select前回対象日(市町村コード);
        if (entityList == null || entityList.isEmpty()) {
            return new ArrayList<>();
        }
        List<ShoriDateKanri> kanriList = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            kanriList.add(new ShoriDateKanri(entity));
        }
        return kanriList;
    }

    /**
     * 高額サービス費支給決定通知書作成画面入力するデータより、バッチ用パラメータクラスを作成する。
     *
     * @param parameter ShikyuketteituchishoSakuseiJyokenParameter
     * @return
     * {@link DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter}
     */
    public DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter
            getDBC020030_KougakuSabisuhiShikyuuKetteiTsuchishoBatchParameter(KogakuJigyoServicehiShikyuKetteiTsuchishoParameter parameter) {
        DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter batchParameter
                = new DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter();
        batchParameter.set抽出モード(parameter.get抽出モード());
        batchParameter.set抽出条件日付From(parameter.get抽出条件日付From());
        batchParameter.set抽出条件日付To(parameter.get抽出条件日付To());
        batchParameter.set決定者受付年月(parameter.get決定者受付年月());
        batchParameter.set印書(parameter.get印書());
        batchParameter.set高額自動償還(parameter.get高額自動償還());
        batchParameter.set発行日(parameter.get発行日());
        batchParameter.set文書番号(parameter.get文書番号());
        batchParameter.setテスト出力フラグ(parameter.getテスト出力フラグ());
        batchParameter.set決定日一括更新区分(parameter.get決定日一括更新区分());
        batchParameter.set決定日(parameter.get決定日());
        batchParameter.set利用者向け決定通知書フラグ(parameter.get利用者向け決定通知書フラグ());
        batchParameter.set受領委任者向け決定通知書フラグ(parameter.get受領委任者向け決定通知書フラグ());
        batchParameter.set振込予定日(parameter.get振込予定日());
        batchParameter.set支払場所(parameter.get支払場所());
        batchParameter.set支払期間From(parameter.get支払期間From());
        batchParameter.set支払期間To(parameter.get支払期間To());
        batchParameter.set開始時間(parameter.get開始時間());
        batchParameter.set終了時間(parameter.get終了時間());
        batchParameter.set出力順ID(parameter.get出力順ID());
        return batchParameter;
    }

    /**
     * 高額総合事業サービス費支給決定通知書作成画面入力するデータより、バッチ用パラメータクラスを作成する。
     *
     * @param parameter ShikyuketteituchishoSakuseiJyokenParameter
     * @return
     * {@link DBC020030_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter}
     */
    public DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter
            getDBC020060_KougakuSabisuhiShikyuuKetteiTsuchishoBatchParameter(KogakuJigyoServicehiShikyuKetteiTsuchishoParameter parameter) {
        DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter batchParameter
                = new DBC020060_KogakuKaigoServicehiShikyuKetteiTsuchishoParameter();
        batchParameter.set抽出モード(parameter.get抽出モード());
        batchParameter.set抽出条件日付From(parameter.get抽出条件日付From());
        batchParameter.set抽出条件日付To(parameter.get抽出条件日付To());
        batchParameter.set決定者受付年月(parameter.get決定者受付年月());
        batchParameter.set印書(parameter.get印書());
        batchParameter.set高額自動償還(parameter.get高額自動償還());
        batchParameter.set発行日(parameter.get発行日());
        batchParameter.set文書番号(parameter.get文書番号());
        batchParameter.setテスト出力フラグ(parameter.getテスト出力フラグ());
        batchParameter.set決定日一括更新区分(parameter.get決定日一括更新区分());
        batchParameter.set決定日(parameter.get決定日());
        batchParameter.set利用者向け決定通知書フラグ(parameter.get利用者向け決定通知書フラグ());
        batchParameter.set受領委任者向け決定通知書フラグ(parameter.get受領委任者向け決定通知書フラグ());
        batchParameter.set振込予定日(parameter.get振込予定日());
        batchParameter.set支払場所(parameter.get支払場所());
        batchParameter.set支払期間From(parameter.get支払期間From());
        batchParameter.set支払期間To(parameter.get支払期間To());
        batchParameter.set開始時間(parameter.get開始時間());
        batchParameter.set終了時間(parameter.get終了時間());
        batchParameter.set出力順ID(parameter.get出力順ID());
        return batchParameter;
    }
}
