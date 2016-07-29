/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.FukaParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchokarisanteifuka.TokuchoKariSanteiEntity;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoBatchParameter;
import jp.co.ndensan.reams.db.dbb.definition.mybatisprm.tokuchokarisanteitsuchishohakko.KarisanteiBatchEntity;
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
 * @reamsid_L DBB-0790-020 chenaoqi
 *
 */
public class TokuchoKariSanteiFuka {

    private static final RString STR1 = new RString("1");
    private static final RString STR0 = new RString("0");
    private static final RString STR連帳区分 = new RString("連帳区分");
    private static final RString 通知書タイプ = new RString("通知書タイプ");
    private static final RString MINYEAR = new RString("0000");
    private static final RString STR1010 = new RString("1010");
    private static final RString STR1011 = new RString("1011");
    private static final RString STR0030 = new RString("0030");
    private static final RString STR0031 = new RString("0031");
    private static final RString STR0020 = new RString("0020");
    private static final RString STR0021 = new RString("0021");
    private static final RString STR0010 = new RString("0010");
    private static final RString STR0011 = new RString("0011");
    private static final RString 特別徴収開始通知書仮代表 = new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKariDaihyo");
    private static final RString 特別徴収仮算定結果一覧 = new RString("DBB200002_TokubetsuChoshuKarisanteiKekkaIchiran");
    private static final RString 帳票1010 = new RString("DBB100005_TokubetsuChoshuKaishiTsuchishoKariSealer");
    private static final RString 帳票1011 = new RString("DBB100006_TokubetsuChoshuKaishiTsuchishoKariSealerRencho");
    private static final RString 帳票0030 = new RString("DBB100008_TokubetsuChoshuKaishiTsuchishoKariOverlayA4Tate");
    private static final RString 帳票0020 = new RString("DBB100009_TokubetsuChoshuKaishiTsuchishoKariOverlayB5Yoko");
    private static final RString 帳票0010 = new RString("DBB100003_TokubetsuChoshuKaishiTsuchishoKariB5");
    private static final RString 帳票0011 = new RString("DBB100004_TokubetsuChoshuKaishiTsuchishoKariB5Rencho");
    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;
    private final DbT7067ChohyoSeigyoHanyoDac 帳票制御汎用Dac;
    private boolean 一括発行起動フラグ;

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
     * @return
     * {@link InstanceProvider#create}にて生成した{@link TokuchoKariSanteiFuka}のインスタンス
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
        if (STR0.equals(遷移元区分)) {
            entityList = 処理日付管理Dac.select処理状況_特徴仮算定賦課(調定年度);
        } else if (STR1.equals(遷移元区分)) {
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
    public TokuchoKaishiTsuchishoBatchParameter createTokuchoKariSanteiParameter(FukaParameter parameter) {
        List<KarisanteiBatchEntity> 出力帳票一覧List = get出力帳票一覧(parameter.get出力帳票一覧List());
        TokuchoKaishiTsuchishoBatchParameter resultParameter = new TokuchoKaishiTsuchishoBatchParameter();
        resultParameter.set調定年度(parameter.get調定年度());
        resultParameter.set賦課年度(parameter.get賦課年度());
        resultParameter.set発行日(parameter.get発行日());
        resultParameter.set出力対象(parameter.get出力対象());
        resultParameter.set出力帳票一覧(出力帳票一覧List);
        resultParameter.set一括発行起動フラグ(一括発行起動フラグ);
        return resultParameter;
    }

    /**
     * 出力帳票一覧作成
     *
     * @param 出力帳票List TokuchoKariSanteiEntity
     * @return バッチ出力帳票リスト
     */
    private List<KarisanteiBatchEntity> get出力帳票一覧(List<TokuchoKariSanteiEntity> 出力帳票List) {
        List<KarisanteiBatchEntity> resultList = new ArrayList<>();
        KarisanteiBatchEntity バッチ出力帳票entity = new KarisanteiBatchEntity();
        if (出力帳票List == null || 出力帳票List.isEmpty()) {
            return resultList;
        }
        for (TokuchoKariSanteiEntity 出力帳票entity : 出力帳票List) {
            if (new ReportId(特別徴収仮算定結果一覧).equals(出力帳票entity.get帳票分類ID())) {
                バッチ出力帳票entity.set帳票分類ID(出力帳票entity.get帳票分類ID());
                バッチ出力帳票entity.set帳票ID(出力帳票entity.get帳票分類ID());
                バッチ出力帳票entity.set出力順ID(出力帳票entity.get出力順ID());
            } else if (new ReportId(特別徴収開始通知書仮代表)
                    .equals(出力帳票entity.get帳票分類ID())) {
                一括発行起動フラグ = true;
                ChohyoSeigyoHanyo 帳票タイプ = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課,
                        出力帳票entity.get帳票分類ID(),
                        new FlexibleYear(MINYEAR), 通知書タイプ);
                ChohyoSeigyoHanyo 連帳区分 = getChohyoHanyoKey(SubGyomuCode.DBB介護賦課,
                        出力帳票entity.get帳票分類ID(),
                        new FlexibleYear(MINYEAR),
                        STR連帳区分);
                RString 帳票ID = get帳票ID(帳票タイプ, 連帳区分);
                バッチ出力帳票entity.set帳票分類ID(出力帳票entity.get帳票分類ID());
                バッチ出力帳票entity.set帳票ID(new ReportId(帳票ID));
                バッチ出力帳票entity.set出力順ID(出力帳票entity.get出力順ID());
            }
            resultList.add(バッチ出力帳票entity);
        }
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
            if (STR0011.equals(組み合わせ)) {
                帳票ID = 帳票0011;
            } else if (STR0010.equals(組み合わせ)) {
                帳票ID = 帳票0010;
            } else if (STR0021.equals(組み合わせ)) {
                帳票ID = 帳票0020;
            } else if (STR0020.equals(組み合わせ)) {
                帳票ID = 帳票0020;
            } else if (STR0031.equals(組み合わせ)) {
                帳票ID = 帳票0030;
            } else if (STR0030.equals(組み合わせ)) {
                帳票ID = 帳票0030;
            } else if (STR1011.equals(組み合わせ)) {
                帳票ID = 帳票1011;
            } else if (STR1010.equals(組み合わせ)) {
                帳票ID = 帳票1010;
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
