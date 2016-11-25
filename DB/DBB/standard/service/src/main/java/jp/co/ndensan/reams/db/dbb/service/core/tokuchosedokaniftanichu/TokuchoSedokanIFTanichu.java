/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchosedokaniftanichu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.choshuyuyo.tokuchosedokaniftanichu.TokuchoSedokanIFTanichuResult;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB231001.DBB231001_TokuchoSeidokanIFSakuseiParameter;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 *
 * ビジネス設計_DBBBZ84001_2_特徴制度間Ｉ／Ｆ（単一他社）
 *
 * @reamsid_L DBB-1830-030 yangchenbing
 */
public class TokuchoSedokanIFTanichu {

    private static final RString 年度内連番_0001 = new RString("0001");
    private static final RString 年度内連番_0002 = new RString("0002");
    private static final RString 年度内連番_0003 = new RString("0003");
    private static final RString 年度内連番_0004 = new RString("0004");
    private static final RString 年度内連番_0005 = new RString("0005");
    private static final RString 年度内連番_0006 = new RString("0006");
    private static final RString 特別徴収開始年月_02 = new RString("02");
    private static final RString 特別徴収開始年月_04 = new RString("04");
    private static final RString 特別徴収開始年月_06 = new RString("06");
    private static final RString 特別徴収開始年月_08 = new RString("08");
    private static final RString 特別徴収開始年月_10 = new RString("10");
    private static final RString 特別徴収開始年月_12 = new RString("12");
    private static final int NUM1 = 1;
    private final DbT7022ShoriDateKanriDac 処理日付管理マスタdac;

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理マスタdac DbT7022ShoriDateKanriDac
     */
    public TokuchoSedokanIFTanichu(DbT7022ShoriDateKanriDac 処理日付管理マスタdac) {
        this.処理日付管理マスタdac = 処理日付管理マスタdac;
    }

    /**
     * コンストラクタです。
     */
    public TokuchoSedokanIFTanichu() {
        処理日付管理マスタdac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * 処理日付管理マスタから処理状況一覧情報を取得する。
     *
     * @return List<TokuchoSedokanIFTanichuResult>
     */
    public List<TokuchoSedokanIFTanichuResult> getTokuchoKaishiYMList() {
        List<DbT7022ShoriDateKanriEntity> entityList = 処理日付管理マスタdac.selectallbykey(ShoriName.特徴対象者同定.get名称());
        List<TokuchoSedokanIFTanichuResult> resultList = new ArrayList();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            set特別徴収開始年月(entity, resultList);
        }
        return resultList;
    }

    private void set特別徴収開始年月(DbT7022ShoriDateKanriEntity entity, List<TokuchoSedokanIFTanichuResult> resultlist) {
        TokuchoSedokanIFTanichuResult result = new TokuchoSedokanIFTanichuResult();
        result.set年度(entity.getNendo());
        if (年度内連番_0001.equals(entity.getNendoNaiRenban())) {
            result.set特徴開始年月(new RDate(result.get年度().toDateString().concat(特別徴収開始年月_08).toString()));
        } else if (年度内連番_0002.equals(entity.getNendoNaiRenban())) {
            result.set特徴開始年月(new RDate(result.get年度().toDateString().concat(特別徴収開始年月_10).toString()));
        } else if (年度内連番_0003.equals(entity.getNendoNaiRenban())) {
            result.set特徴開始年月(new RDate(result.get年度().toDateString().concat(特別徴収開始年月_12).toString()));
        } else if (年度内連番_0004.equals(entity.getNendoNaiRenban())) {
            result.set特徴開始年月(new RDate(result.get年度().plusYear(NUM1).toDateString().concat(特別徴収開始年月_02).toString()));
        } else if (年度内連番_0005.equals(entity.getNendoNaiRenban())) {
            result.set特徴開始年月(new RDate(result.get年度().plusYear(NUM1).toDateString().concat(特別徴収開始年月_04).toString()));
        } else if (年度内連番_0006.equals(entity.getNendoNaiRenban())) {
            result.set特徴開始年月(new RDate(result.get年度().plusYear(NUM1).toDateString().concat(特別徴収開始年月_06).toString()));
        }
        resultlist.add(result);
    }

    /**
     * 前回処理関連情報を取得する。
     *
     * @param 処理年度 FlexibleYear
     * @param 年度内連番 RString
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> getSyoriKanrenJoho(FlexibleYear 処理年度, RString 年度内連番) {
        RString 処理名 = ShoriName.特別徴収制度間ＩＦ作成.get名称();
        List<DbT7022ShoriDateKanriEntity> 処理日付管理マスタList = 処理日付管理マスタdac.select処理状況(処理年度, 処理名, 年度内連番);
        List<ShoriDateKanri> shoridatekanriList = new ArrayList();
        if (処理日付管理マスタList.isEmpty()) {
            return null;
        } else {
            for (DbT7022ShoriDateKanriEntity entity : 処理日付管理マスタList) {
                shoridatekanriList.add(new ShoriDateKanri(entity));
            }
        }
        return shoridatekanriList;
    }

    /**
     * 画面divより、バッチパラメータを用意する。
     *
     * @param result TokuchoSedokanIFTanichuResult
     * @return TokuchoSeidokanIFSakuseiBatchParameter
     */
    public DBB231001_TokuchoSeidokanIFSakuseiParameter getBatchiPara(TokuchoSedokanIFTanichuResult result) {
        DBB231001_TokuchoSeidokanIFSakuseiParameter param = new DBB231001_TokuchoSeidokanIFSakuseiParameter();
        param.set処理年度(result.get年度());
        param.set特別徴収開始年月(result.get特徴開始年月());
        param.set遷移元メニュー(result.get遷移元メニュー());
        return param;
    }
}
