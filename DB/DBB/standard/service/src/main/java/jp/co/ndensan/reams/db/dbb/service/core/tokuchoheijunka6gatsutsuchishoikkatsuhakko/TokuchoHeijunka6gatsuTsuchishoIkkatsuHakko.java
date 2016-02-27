/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchoheijunka6gatsutsuchishoikkatsuhakko;

import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchoheijunka6gatsutsuchishoikkatsuhakko.TokuchoHeijunka6gatsuMyBatisParameter;
import jp.co.ndensan.reams.db.dbb.entity.dbbbt35003.ChohyoHakkoEntity;
import jp.co.ndensan.reams.db.dbb.persistence.db.mapper.tokuchoheijunka6gatsutsuchishoikkatsuhakko.ITokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper;
import jp.co.ndensan.reams.db.dbb.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 特徴平準化（特徴6月分）通知書一括発行(バッチ)
 */
public class TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko {

    private final MapperProvider mapperProvider;
    private final ITokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper mapper;

    /**
     * コンストラクタです。
     */
    public TokuchoHeijunka6gatsuTsuchishoIkkatsuHakko() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.mapper = mapperProvider.create(ITokuchoHeijunka6gatsuTsuchishoIkkatsuHakkoMapper.class);
    }

    /**
     * 賦課情報取得
     *
     * @param 調定年度 調定年度
     * @param 一括発行起動フラグ 一括発行起動フラグ
     */
    public void getFukaJoho(RString 調定年度, boolean 一括発行起動フラグ) {

        TokuchoHeijunka6gatsuMyBatisParameter param = new TokuchoHeijunka6gatsuMyBatisParameter();
        param.set調定年度(調定年度);
        param.setサブ業務コード(SubGyomuCode.DBB介護賦課);
        param.set処理名(ShoriName.特徴平準化計算_6月分);

        if (一括発行起動フラグ) {
//            DbT7022ShoriDateKanriEntity dbT7022ShoriDateKanriEntity
//            = dbT7022ShoriDateKanriDac.selectMax基準日時(new FlexibleYear(調定年度), ShoriName.特徴平準化計算_6月分.get名称());
//            YMDHMS 基準日時_MAX = dbT7022ShoriDateKanriEntity.getKijunTimestamp();
            //TODO 計算後情報作成バッチを呼び出す。

            mapper.select特徴平準化_6月分更新後とリアルのデータ(param);
            mapper.update仮算定額変更情報一時テーブルの計算後情報更正前情報1(param);
        } else {
            mapper.select特徴平準化_6月分更新後のデータ();
//            mapper.update仮算定額変更情報一時テーブルの計算後情報更正前情報2(param);
        }
        mapper.update更正前の対象者_追加含む_情報();
        //TODO 普徴納期情報リストと特徴納期情報リストの作成
        mapper.select全ての賦課情報();
        mapper.update前年度特徴期別金額06();
        mapper.update継続の被保険者区分();
        mapper.update4月開始の被保険者区分();
        mapper.update6月開始の被保険者区分();
    }

    /**
     * 通知書の発行
     *
     * @param param 帳票発行のパラメータ
     */
    public void printTsuchisho(ChohyoHakkoEntity param) {
//        // 出力対象データの取得
////        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
////        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBB介護賦課, REPORT_ID_DBB100012,
//        Long.parseLong(param.get出力順ID().toString()));
//
////        RString 出力順 = MyBatisOrderByClauseCreator.create(null, outputOrder);  //TODO  帳票出力順・改ページ項目一覧（DBB介護賦課）.xlsx
//        List<DbT2015KeisangoJohoEntity> keisangoJohoList = new ArrayList<>(); // TODO  SQL
//
//        //TODO 帳票制御共通情報の取得
////        DbT7065ChohyoSeigyoKyotsuDac dac = InstanceProvider.create(DbT7065ChohyoSeigyoKyotsuDac.class);
////        DbT7065ChohyoSeigyoKyotsuEntity entity = dac.selectByKey(SubGyomuCode.DBB介護賦課, REPORT_ID_DBB100012);
//
//        // 共通的な項目の編集を行う
//        Association association = AssociationFinderFactory.createInstance().getAssociation();
////        RString 市町村コード = association.get地方公共団体コード().value();
////        RString 市町村名 = association.get市町村名();
//
//        // 仮算定額変更通知書共通情報の編集処理
//        KaigoFukaTokuchoHeijunka6 KaigoFukaTokuchoHeijunka6 = new KaigoFukaTokuchoHeijunka6();  // TODO  entity設計書より
//        for (DbT2015KeisangoJohoEntity keisangoJoho : keisangoJohoList) {
//            // 仮算定額変更通知書情報を作成する。
//            KaigoFukaTokuchoHeijunka6 = new KaigoFukaTokuchoHeijunka6();
//            KariSanteiTsuchiShoKyotsu kariSanteiTsuchiShoKyotsu = new KariSanteiTsuchiShoKyotsu();
//            kariSanteiTsuchiShoKyotsu.set発行日(new FlexibleDate(param.get発行日().toDateString()));
//            kariSanteiTsuchiShoKyotsu.set帳票分類ID(REPORT_ID_DBB100012.getColumnValue());
//            kariSanteiTsuchiShoKyotsu.set処理区分(ShoriKubun.バッチ);
//            kariSanteiTsuchiShoKyotsu.set地方公共団体(association);
////            kariSanteiTsuchiShoKyotsu.set賦課の情報_更正後();
//
//            // 4.2共通編集処理を呼び出す。  TODO 未作成  0226納品
//            // 4.3通知書一覧について、ＣＳＶファイルに出力する項目を編集する。
//            // 4.4通知書一覧について、ＣＳＶファイルに出力する項目を編集する。
//            // 4.5通知書について、帳票に出力する項目を編集する。
//        }
//
//        // 4.6 通知書帳票をスプール登録する
//        // 4.7 通知書一覧帳票をスプール登録する
//        // 4.8 CSVファイルの文字コードを指定された文字コードに変換する
//        // 4.9 CSVファイルをスプール登録する（TechwikiのEUC用CSVファイル出力API利用ガイドライン参照）
//        // 4.10 仮算定額変更通知書を作成する時、文字切れがある項目について、
//        文字切れ情報をCheckListLineItemSet_ISpecificKeyとCheckListLineItemSet_ICheckTargetに追加する
//        // 5 発行履歴の登録
//        IHakkoRirekiManager iHakkoRirekiManager = HakkoRirekiManagerFactory.createInstance();
//        // 1:SourceData   3:初期発行状態  4:発行履歴固有情報Map  5:識別コードList
//        iHakkoRirekiManager.insert帳票発行履歴(null, new FlexibleDate(param.get発行日().toDateString()), ChohyoHakkoRirekiJotai.未定, null, null);
//
//        // 文字切れチェックリストの出力
//        if (!keisangoJohoList.isEmpty()) {
//
//        }

    }

    /**
     * 通知書発行後異動者登録
     *
     * @param 帳票作成日時 RString
     * @param 出力順ID RString
     * @param 出力対象区分 RString
     * @param 帳票ID RString
     */
    public void insTsuchishoHakkogoIdosha(
            RString 帳票作成日時, Long 出力順ID, RString 出力対象区分, RString 帳票ID
    ) {
//        IOutputOrder ioutputorder = ChohyoShutsuryokujunFinderFactory.createInstance()
//                .get出力順(SubGyomuCode.DBB介護賦課,
//                        ReportId.EMPTY,
//                        帳票ID, 出力順ID);
        //UrControlDataFactory.createInstance().getLoginInfo().getUserId();
//        RString 出力順 = MyBatisOrderByClauseCreator.create(null, ioutputorder);
        mapper.insert入力の出力対象区分によって();

    }

}
