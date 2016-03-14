/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.kaigofukatokuchoheijunka6.ShorijyokyoJoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.KaigoFukaTokuchoHeijunkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.ShorijyokyoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.ShuturyokuChohuoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.kaigofukatokuchoheijunka6.TokuchoHeijunka6BatchParameterEntity;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.FuchoKiUtil;
import jp.co.ndensan.reams.db.dbx.business.core.kanri.KitsukiList;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
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
    private static final RString 標準版B5横タイプ = new RString("001");
    private static final RString 標準版A4縦タイプ = new RString("002");
    private static final ReportId 通知書帳票ID_００１ = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoB5Yoko");
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
            DbT7067ChohyoSeigyoHanyoEntity dbT7067ChohyoSeigyoHanyoEntity
                    = get帳票制御汎用キー(SubGyomuCode.DBB介護賦課, entity.get帳票分類ＩＤ(), entity.get調定年度(), 項目名);
            RString komokuValue = RString.EMPTY;
            if (dbT7067ChohyoSeigyoHanyoEntity != null) {
                komokuValue = dbT7067ChohyoSeigyoHanyoEntity.getKomokuValue();
            }
            if (標準版B5横タイプ.equals(komokuValue)) {
                shuturyokuChohuo.set帳票ID(通知書帳票ID_００１);
            } else if (標準版A4縦タイプ.equals(komokuValue)) {
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
    public List<ShorijyokyoJoho> getShoriJohkyoList(RString 遷移元区分, FlexibleYear 調定年度) {

        ShorijyokyoEntity shoriEntity = new ShorijyokyoEntity();
        List<ShorijyokyoJoho> shoriList = new ArrayList<>();
        DbT7022ShoriDateKanriDac bT7022ShoriDateKanriDac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);

        List<RString> 処理名 = new ArrayList<>();

        if (遷移元区分_0.equals(遷移元区分)) {
            FuchoKiUtil fuchoKiUtil = new FuchoKiUtil(調定年度);
            KitsukiList 期月リスト = fuchoKiUtil.get期月リスト().filtered仮算定期間();
            int count = 期月リスト.toList().size();
            if (count >= 1) {
                処理名.add(ShoriName.特徴仮算定賦課.get名称());
                処理名.add(ShoriName.普徴仮算定賦課.get名称());
            } else {
                処理名.add(ShoriName.特徴仮算定賦課.get名称());
            }
            List<DbT7022ShoriDateKanriEntity> entityList = bT7022ShoriDateKanriDac.select処理状況(調定年度, 処理名);
            for (DbT7022ShoriDateKanriEntity entity : entityList) {
                shoriEntity = new ShorijyokyoEntity();
                shoriEntity.set処理名(entity.getShoriName());
                shoriEntity.set基準年月日(entity.getKijunYMD());
                shoriEntity.set基準日時(entity.getKijunTimestamp());
                shoriList.add(new ShorijyokyoJoho(shoriEntity));
            }
        } else if (遷移元区分_1.equals(遷移元区分)) {
            処理名.add(ShoriName.特徴平準化計算_6月分.get名称());
            List<DbT7022ShoriDateKanriEntity> entityList = bT7022ShoriDateKanriDac.select処理状況(調定年度, 処理名);
            for (DbT7022ShoriDateKanriEntity entity : entityList) {
                shoriEntity = new ShorijyokyoEntity();
                shoriEntity.set処理名(entity.getShoriName());
                shoriEntity.set基準年月日(entity.getKijunYMD());
                shoriEntity.set基準日時(entity.getKijunTimestamp());
                shoriList.add(new ShorijyokyoJoho(shoriEntity));
            }
        }
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
    private DbT7067ChohyoSeigyoHanyoEntity get帳票制御汎用キー(SubGyomuCode サブ業務コード, ReportId 帳票分類ID,
            FlexibleYear 調定年度, RString 項目名) {
        DbT7067ChohyoSeigyoHanyoDac dbT7067ChohyoSeigyoHanyoDac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        DbT7067ChohyoSeigyoHanyoEntity entity = dbT7067ChohyoSeigyoHanyoDac.selectByKey(サブ業務コード, 帳票分類ID, 調定年度, 項目名);
        return entity;
    }
}
