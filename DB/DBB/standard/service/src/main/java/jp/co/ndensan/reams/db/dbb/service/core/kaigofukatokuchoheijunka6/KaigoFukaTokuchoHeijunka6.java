/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.TokuchoHeijunka6BatchParameterEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.KaigoFukaTokuchoHeijunkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.ShuturyokuChohuoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.ShorijyokyoEntity;
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
 * 特徴平準化（特徴6月分）のビジネスクラスです。
 *
 */
public class KaigoFukaTokuchoHeijunka6 {

    private static final ReportId 帳票分類ＩＤ = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final RString 項目名 = new RString("通知書タイプ");
    private static final RString 標準版B5横タイプ = new RString("標準版B5横タイプ");
    private static final RString 標準版A4縦タイプ = new RString("標準版A4縦タイプ");
    private static final ReportId 通知書帳票ID_００１ = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private static final ReportId 通知書帳票ID_００２ = new ReportId("DBB100013_KarisanteiHenjunkaHenkoTsuchishoA4Tate");
    private static final RString 遷移元区分_0 = new RString("0");
    private static final RString 遷移元区分_1 = new RString("1");

    /**
     * コンストラクタです。
     */
    public KaigoFukaTokuchoHeijunka6() {
    }

    /**
     * バッチパラメータの取得
     *
     * @param entity 画面情報
     * @return batchParameterクラス
     */
    public TokuchoHeijunka6BatchParameterEntity getBatchiPara(KaigoFukaTokuchoHeijunkaEntity entity) {
        TokuchoHeijunka6BatchParameterEntity batchParameter = new TokuchoHeijunka6BatchParameterEntity();
        batchParameter.set調定年度(entity.get調定年度());
        batchParameter.set賦課年度(entity.get賦課年度());
        batchParameter.set増額平準化方法(entity.get増額平準化方法());
        batchParameter.set減額平準化方法(entity.get減額平準化方法());
        batchParameter.set帳票グループ(entity.get帳票グループ());

        ShuturyokuChohuoEntity shuturyokuChohuo = new ShuturyokuChohuoEntity();
        shuturyokuChohuo.set帳票分類ID(entity.get帳票分類ＩＤ());
        if (帳票分類ＩＤ.equals(entity.get帳票分類ＩＤ())) {
            DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity = get帳票制御汎用キー(SubGyomuCode.DBB介護賦課, entity.get帳票分類ＩＤ(), entity.get調定年度(), 項目名);
            if (dbT7067ChohyoSeigyoHanyoEntity.getKomokuName().equals(標準版B5横タイプ)) {
                shuturyokuChohuo.set帳票ID(通知書帳票ID_００１);
            } else if (dbT7067ChohyoSeigyoHanyoEntity.getKomokuName().equals(標準版A4縦タイプ)) {
                shuturyokuChohuo.set帳票ID(通知書帳票ID_００２);
            }
        } else {
            shuturyokuChohuo.set帳票ID(entity.get帳票分類ＩＤ());
        }
        shuturyokuChohuo.set帳票名(entity.get帳票名());
        shuturyokuChohuo.set改頁出力順ID(entity.get改頁出力順ID());

        List<ShuturyokuChohuoEntity> shuturyokuChohuoList = new ArrayList<>();
        shuturyokuChohuoList.add(shuturyokuChohuo);
        batchParameter.set出力帳票entity(shuturyokuChohuoList);
        batchParameter.set出力対象指示フラグ(entity.get出力対象指示フラグ());
        batchParameter.set発行日(entity.get発行日());
        batchParameter.set文書番号(entity.get文書番号());
        return batchParameter;
    }

    /**
     * 処理状況取得
     *
     * @param 遷移元区分 遷移元区分
     * @param 調定年度 調定年度
     * @return 処理状況リスト<処理日付管理entity>
     */
    public List<ShorijyokyoEntity> getShoriJohkyoList(RString 遷移元区分, FlexibleYear 調定年度) {
        ShorijyokyoEntity shoriEntity = new ShorijyokyoEntity();
        DbT7022ShoriDateKanriDac bT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
        if (遷移元区分_0.equals(遷移元区分)) {
            // TODO QA #73929  共通クラスの月期対応取得_普徴．get期月リスト()がまだ作成していないので、残留。
            DbT7022ShoriDateKanriEntity DateKanriEntity
                    = bT7022ShoriDateKanriDac.select処理状況_1(調定年度);
            shoriEntity.set処理名(DateKanriEntity.getShoriName());
            shoriEntity.set基準年月日(DateKanriEntity.getKijunYMD());
            shoriEntity.set基準日時(DateKanriEntity.getKijunTimestamp());
        } else if (遷移元区分_1.equals(遷移元区分)) {
            DbT7022ShoriDateKanriEntity DateKanriEntity
                    = bT7022ShoriDateKanriDac.select処理状況_2(調定年度);
            shoriEntity.set処理名(DateKanriEntity.getShoriName());
            shoriEntity.set基準年月日(DateKanriEntity.getKijunYMD());
            shoriEntity.set基準日時(DateKanriEntity.getKijunTimestamp());
        }
        List<ShorijyokyoEntity> shoriList = new ArrayList<>();
        shoriList.add(shoriEntity);
        return shoriList;
    }

    /**
     * 帳票制御汎用キー取得
     *
     * @param サブ業務コード サブ業務コード
     * @param 帳票分類ID 帳票分類ID
     * @param 調定年度 調定年度
     * @param 項目名 項目名
     * @return 帳票制御汎用Entity
     */
    private DbT7067ChohyoSeigyoHanyoEntity get帳票制御汎用キー(SubGyomuCode サブ業務コード, ReportId 帳票分類ID, FlexibleYear 調定年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067ChohyoSeigyoHanyoDac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dbT7067ChohyoSeigyoHanyoDac.selectByKey(サブ業務コード, 帳票分類ID, 調定年度, 項目名);
        if (entity == null) {
            return null;
        }
        return entity;
    }
}
