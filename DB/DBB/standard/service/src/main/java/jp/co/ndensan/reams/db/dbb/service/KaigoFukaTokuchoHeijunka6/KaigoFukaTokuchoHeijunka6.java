/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.KaigoFukaTokuchoHeijunka6;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gamendiv.BatchParameterEntity;

import jp.co.ndensan.reams.db.dbb.entity.db.basic.gamendiv.KaigoFukaTokuchoHeijunkaEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gamendiv.ShuturyokuChohuoEntity;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.gamendiv.shorijyokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7067ChohyoSeigyoHanyoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7067ChohyoSeigyoHanyoDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;

import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * 介護賦課_特徴平準化（特徴6月分）
 */
public class KaigoFukaTokuchoHeijunka6 {

    private final ReportId 帳票分類ＩＤ = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private RString 通知書ID ;
    private final RString 帳票タイプ_1 = new RString("001");
    private final RString 帳票タイプ_2 = new RString("002");
    private final ReportId 通知書帳票ID_1 = new ReportId("DBB100012_KarisanteiHenjunkaHenkoTsuchishoDaihyo");
    private final ReportId 通知書帳票ID_2 = new ReportId("DBB100013_KarisanteiHenjunkaHenkoTsuchishoA4Tate");
    private final RString 遷移元区分_0 = new RString("0");
    private final RString 遷移元区分_1 = new RString("1");
    private final SubGyomuCode サブ業務コード = new SubGyomuCode("DBB");
    private final RString 項目名_1 = new RString("標準版B5横タイプ");
    private final RString 項目名_2 = new RString("標準版A4縦タイプ");
    private final DbT7067ChohyoSeigyoHanyoDac seigyohanyodac;
    private final DbT7022ShoriDateKanriDac shoridatekanridac;

    /**
     * コンストラクタです。
     */
    public KaigoFukaTokuchoHeijunka6() {
        seigyohanyodac = InstanceProvider.create(DbT7067ChohyoSeigyoHanyoDac.class);
        shoridatekanridac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param SeigyoHanyoDac {@link DbT2006ChoshuYuyoDac}
     * @param ShoriDateKanriDac {@link DbT7022ShoriDateKanriDac}
     */
    KaigoFukaTokuchoHeijunka6(DbT7067ChohyoSeigyoHanyoDac seigyohanyodac, DbT7022ShoriDateKanriDac shoridatekanridac) {
        this.seigyohanyodac = seigyohanyodac;
        this.shoridatekanridac = shoridatekanridac;
    }

    /**
     *
     * 画面divより、バッチパラメータを用意する
     *
     * @param entity
     * @return batchParameter
     */
    public BatchParameterEntity getBatchiPara(KaigoFukaTokuchoHeijunkaEntity entity) {
        List<ShuturyokuChohuoEntity> shuturyokuChohuoList = new ArrayList();
        ShuturyokuChohuoEntity shuturyokuChohuo = new ShuturyokuChohuoEntity();
        BatchParameterEntity batchParameter = new BatchParameterEntity();
        batchParameter.set調定年度(entity.get調定年度());
        batchParameter.set賦課年度(entity.get賦課年度());
        batchParameter.set増額平準化方法(entity.get増額平準化方法());
        batchParameter.set減額平準化方法(entity.get減額平準化方法());
        batchParameter.set帳票グループ(entity.get帳票グループ());
        shuturyokuChohuo.set帳票分類ID(entity.get帳票分類ＩＤ());
        if (this.帳票分類ＩＤ.equals(entity.get帳票分類ＩＤ())) {
            if (get帳票制御汎用キー(this.サブ業務コード, this.帳票分類ＩＤ, entity.get項目名()).getKomokuName().equals(項目名_1)) {
                this.通知書ID = 帳票タイプ_1;
                shuturyokuChohuo.set帳票ID(通知書帳票ID_1);
            } else if (get帳票制御汎用キー(this.サブ業務コード, this.帳票分類ＩＤ, entity.get項目名()).getKomokuName().equals(項目名_2)) {
                this.通知書ID = 帳票タイプ_2;
                shuturyokuChohuo.set帳票ID(通知書帳票ID_2);
            }

        } else {
            shuturyokuChohuo.set帳票ID(entity.get帳票分類ＩＤ());
        }
        shuturyokuChohuo.set帳票名(entity.get帳票名());
        shuturyokuChohuo.set改頁出力順ID(entity.get改頁出力順ID());
        shuturyokuChohuoList.add(shuturyokuChohuo);
        batchParameter.set出力帳票entity(shuturyokuChohuoList);
        batchParameter.set出力対象指示フラグ(entity.get出力対象指示フラグ());
        batchParameter.set発行日(entity.get発行日());
        batchParameter.set文書番号(entity.get文書番号());
        return batchParameter;

    }

    /**
     *
     * 処理日付管理マスタから処理名に関するの情報を取得する
     * @param entity
     * @return shoriList
     */
    public List<shorijyokyoEntity> getShoriJohkyoList(KaigoFukaTokuchoHeijunkaEntity entity) {
        List<shorijyokyoEntity> shoriList = new ArrayList<>();
        shorijyokyoEntity shoriEntity = new shorijyokyoEntity();
        if (entity.get遷移元区分().equals(遷移元区分_0)) {
            //to do  検索条件：処理名　IN 処理名リスト
            DbT7022ShoriDateKanriEntity DateKanriEntity
                    = shoridatekanridac.select処理状況_1(entity.get調定年度());
            shoriEntity.set処理名(DateKanriEntity.getShoriName());
            shoriEntity.set基準年月日(DateKanriEntity.getKijunYMD());
            shoriEntity.set基準日時(DateKanriEntity.getKijunTimestamp());
            shoriList.add(shoriEntity);

        } else if (entity.get遷移元区分().equals(遷移元区分_1)) {
            DbT7022ShoriDateKanriEntity DateKanriEntity
                    = shoridatekanridac.select処理状況_2(entity.get調定年度());
            shoriEntity.set処理名(DateKanriEntity.getShoriName());
            shoriEntity.set基準年月日(DateKanriEntity.getKijunYMD());
            shoriEntity.set基準日時(DateKanriEntity.getKijunTimestamp());
            shoriList.add(shoriEntity);
        }
        return shoriList;
    }

    /**
     *
     * 帳票制御汎用キー取得
     *
     * @param サブ業務コード
     * @param 帳票分類ID
     * @param 項目名
     * @return DbT7067ChohyoSeigyoHanyoEntity
     */
    private DbT7067ChohyoSeigyoHanyoEntity get帳票制御汎用キー(SubGyomuCode サブ業務コード, ReportId 帳票分類ID, RString 項目名) {
//        to do  検索条件：管理年度　＝　入力．管理年度 
        DbT7067ChohyoSeigyoHanyoEntity dbentity
                = seigyohanyodac.selectByKey(サブ業務コード, 帳票分類ID, 項目名);
        if (dbentity == null) {
            return null;
        }
        return dbentity;
    }

}
