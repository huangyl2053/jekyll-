/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.BatchTokuchoKariSanteiResult;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.FukaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiParameter;
import jp.co.ndensan.reams.db.dbb.entity.db.relate.tokuchokarisanteifuka.BatchTokuchoEntity;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ33001_特徴仮算定賦課
 *
 */
public class TokuchoKariSanteiFuka {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;

    /**
     * コンストラクタです。
     */
    TokuchoKariSanteiFuka() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        this.帳票制御汎用Dac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);

    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     * * @param 帳票制御汎用Dac DbT7067ChohyoSeigyoHanyoDac
     */
    TokuchoKariSanteiFuka(DbT7022ShoriDateKanriDac 処理日付管理Dac, DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
        this.帳票制御汎用Dac = 帳票制御汎用Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFuka}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFuka}のインスタンス
     */
    public static TokuchoKariSanteiFuka createInstance() {
        return InstanceProvider.create(TokuchoKariSanteiFuka.class);
    }

    /**
     * 処理状況取得
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getShoriDateKanriList(RString 遷移元区分, FlexibleYear 調定年度) {
        List<DbT7022ShoriDateKanriEntity> entityList = new ArrayList<>();
        if (new RString("0").equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_特徴仮算定賦課(調定年度);
        } else if (new RString("1").equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_特徴仮算定通知書一括発行(調定年度);
        }
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
     * バッチパラメータ作成
     *
     * @param parameter FukaParameter
     * @return バッチパラメータ
     */
    public TokuchoKariSanteiParameter createTokuchoKariSanteiParameter(FukaParameter parameter) {
        List<BatchTokuchoKariSanteiResult> 出力帳票一覧List = get出力帳票一覧(parameter.get出力帳票一覧List());
        TokuchoKariSanteiParameter resultParameter = new TokuchoKariSanteiParameter();
        resultParameter.set調定年度(parameter.get調定年度());
        resultParameter.set賦課年度(parameter.get賦課年度());
        resultParameter.set発行日(parameter.get発行日());
        resultParameter.set出力対象(parameter.get出力対象());
        resultParameter.set出力帳票一覧List(出力帳票一覧List);
        return resultParameter;
    }

    /**
     * 出力帳票一覧作成
     *
     * @param 出力帳票List TokuchoKariSanteiEntity
     * @return バッチ出力帳票リスト
     */
    private List<BatchTokuchoKariSanteiResult> get出力帳票一覧(List<TokuchoKariSanteiEntity> 出力帳票List) {
        List<BatchTokuchoKariSanteiResult> resultList = new ArrayList<>();
        BatchTokuchoEntity バッチ出力帳票entity = new BatchTokuchoEntity();
        if (出力帳票List == null || 出力帳票List.isEmpty()) {
            return resultList;
        }
        for (TokuchoKariSanteiEntity 出力帳票entity : 出力帳票List) {
            if (new ReportId("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran").equals(出力帳票entity.get帳票分類ID())) {
                バッチ出力帳票entity.set帳票分類ID(出力帳票entity.get帳票分類ID());
                バッチ出力帳票entity.set帳票ID(出力帳票entity.get帳票分類ID().value());
                バッチ出力帳票entity.set出力順ID(出力帳票entity.get出力順ID());
            } else if (new ReportId("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo")
                    .equals(出力帳票entity.get帳票分類ID())) {
                ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課,
                        出力帳票entity.get帳票分類ID(),
                        new FlexibleYear("0000"),
                        new RString("通知書タイプ"));
                ChohyoSeigyoHanyo 連帳区分 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課,
                        出力帳票entity.get帳票分類ID(),
                        new FlexibleYear("0000"),
                        new RString("連帳区分"));
                RString 帳票ID = get帳票ID(帳票タイプ, 連帳区分);
                バッチ出力帳票entity.set帳票分類ID(出力帳票entity.get帳票分類ID());
                バッチ出力帳票entity.set帳票ID(帳票ID);
                バッチ出力帳票entity.set出力順ID(出力帳票entity.get出力順ID());

            }
        }
        resultList.add(new BatchTokuchoKariSanteiResult(バッチ出力帳票entity));

        return resultList;
    }

    /**
     * 帳票ID取得
     *
     * @param 帳票タイプ ChohyoSeigyoHanyo
     * @param 連帳区分 ChohyoSeigyoHanyo
     * @return 帳票ID
     */
    private RString get帳票ID(ChohyoSeigyoHanyo 帳票タイプ, ChohyoSeigyoHanyo 連帳区分) {
        RString 帳票ID = RString.EMPTY;
        if (帳票タイプ != null && 連帳区分 != null) {
            RString 組み合わせ = 帳票タイプ.get設定値().concat(連帳区分.get設定値());
            switch (組み合わせ.toString()) {
                case "0011":
                    帳票ID = new RString("DBB100004_TokubetsuChoshuKaishiTsuchishoKairiB5Rencho");
                    break;
                case "0010":
                    帳票ID = new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKairiB5");
                    break;
                case "0021":
                    帳票ID = new RString("DBB100009_TokubetsuChoshuKaishiTsuchishoKairiOverlayB5Yoko");
                    break;
                case "0020":
                    帳票ID = new RString("DBB100009_TokubetsuChoshuKaishiTsuchishoKairiOverlayB5Yoko");
                    break;
                case "0031":
                    帳票ID = new RString("DBB100008_TokubetsuChoshuKaishiTsuchishoKairiOverlayA4Tate");
                    break;
                case "0030":
                    帳票ID = new RString("DBB100008_TokubetsuChoshuKaishiTsuchishoKairiOverlayA4Tate");
                    break;
                case "1011":
                    帳票ID = new RString("DBB100006_TokubetsuChoshuKaishiTsuchishoKairiSealerRencho");
                    break;
                case "1010":
                    帳票ID = new RString("DBB100005_TokubetsuChoshuKaishiTsuchishoKairiSealer");
                    break;
                default:
                    帳票ID = new RString("");
            }
        }
        return 帳票ID;
    }

    /**
     * 帳票制御汎用キー取得
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 管理年度 管理年度
     * @param 項目名 項目名
     * @return ChohyoSeigyoHanyo
     */
    private ChohyoSeigyoHanyo getChohyoHanyoKey(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 管理年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoEntity entity
                = 帳票制御汎用Dac.select帳票制御汎用キー(サブ業務コード, 帳票分類ID, 管理年度, 項目名);
        if (entity == null) {
            return null;
        }
        return new ChohyoSeigyoHanyo(entity);
    }

}
