/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeitanitu;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeitanitu.ShotokuJohoBatchresultTanituParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeitanitu.ShotokuJohoTyushutuRenkeiTanituParameter;
import jp.co.ndensan.reams.db.dbb.business.core.shichosonkado.ShichosonJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.ui.servlets.ResponseHolder;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51005_2_所得情報抽出・連携（単一他社）
 *
 * @reamsid_L DBB-1690-050 sunhui
 */
public class ShotokuJohoChushutsuRenkeitanitu {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    private static final RString 処理日付管理マスタ無し = new RString("3");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString 不可 = new RString("2");
    private static final RString 可 = new RString("1");
    private static final RString 共有ファイル名 = new RString("BBKAIGO");
    private static final RString 共有ファイルID = new RString("C:\\Users\\LDNS\\shared\\sharedFiles");
    private static final RString 所得情報抽出_連携当初 = new RString("DBBMN51009");
    private static final RString 所得情報抽出_連携異動 = new RString("DBBMN51010");
    private static final RString 当初_単一 = new RString("3");
    private static final RString 異動_単一 = new RString("4");

    ShotokuJohoChushutsuRenkeitanitu() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    ShotokuJohoChushutsuRenkeitanitu(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShotokuJohoChushutsuRenkeitanitu}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShotokuJohoChushutsuRenkeitanitu}のインスタンス
     */
    public static ShotokuJohoChushutsuRenkeitanitu createInstance() {
        return InstanceProvider.create(ShotokuJohoChushutsuRenkeitanitu.class);
    }

    /**
     * 処理区分取得メソッドです
     *
     * @param 市町村識別ID RString
     * @param 遷移区分 RString
     * @param 年度 FlexibleYear
     * @return 処理区分 RString
     */
    public RString getShoriKubun(RString 市町村識別ID, RString 遷移区分, FlexibleYear 年度) {
        RString 処理区分 = RString.EMPTY;
        YMDHMS 基準日時;
        DbT7022ShoriDateKanriEntity 処理日付管理異動情報Entity;
        if (遷移区分_0.equals(遷移区分)) {
            処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_当初所得情報抽出(年度);
            if (処理日付管理異動情報Entity == null) {
                処理区分 = 処理日付管理マスタ無し;
            } else {
                基準日時 = 処理日付管理異動情報Entity.getKijunTimestamp();
                処理区分 = 基準日時1(基準日時);
            }
            return 処理区分;
        }
        if (遷移区分_1.equals(遷移区分)) {
            処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_当初所得情報抽出(年度);
            if (処理日付管理異動情報Entity == null) {
                処理区分 = 不可;
                return 処理区分;
            } else {
                基準日時 = 処理日付管理異動情報Entity.getKijunTimestamp();
                基準日時2(基準日時);
                以降の判定処理を行わない判別(処理日付管理異動情報Entity, 年度, 処理区分);
            }
            処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_異動所得情報抽出(年度);
            if (処理日付管理異動情報Entity == null) {
                処理区分 = 不可;
            } else {
                処理区分 = 可;
            }
            return 処理区分;
        }
        return 処理区分;
    }

    /**
     * バッチ用パラメータ作成します。
     *
     * @param parameter ShotokuJohoTyushutuRenkeiKoikiParameter
     * @return ShotokuJohoBatchresultParameter createShotokuJohoParameter
     */
    public ShotokuJohoBatchresultTanituParameter createShotokuJohoParameter(
            ShotokuJohoTyushutuRenkeiTanituParameter parameter) {
        ShotokuJohoBatchresultTanituParameter result = new ShotokuJohoBatchresultTanituParameter();
        List<ShichosonJoho> 市町村情報List = new ArrayList<>();
        result.set処理年度(parameter.get処理年度());
        result.set市町村情報List(市町村情報List);
        result.set出力順ID(parameter.get出力順ID());
        result.set帳票ID(new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran"));
        result.set共有ファイル名(共有ファイル名);
        result.set共有ファイルID(共有ファイルID);
        RString メニューID = ResponseHolder.getMenuID();
        if (所得情報抽出_連携当初.equals(メニューID)) {
            result.set処理区分(当初_単一);
        } else if (所得情報抽出_連携異動.equals(メニューID)) {
            result.set処理区分(異動_単一);
        }
        return result;
    }

    private RString 基準日時1(YMDHMS 基準日時) {
        RString 処理区分;
        if (基準日時 != null && !基準日時.isEmpty()) {
            処理区分 = 不可;
        } else {
            処理区分 = 可;
        }
        return 処理区分;
    }

    private RString 基準日時2(YMDHMS 基準日時) {
        RString 処理区分;
        if (基準日時 != null && !基準日時.isEmpty()) {
            処理区分 = 可;
        } else {
            処理区分 = 不可;
        }
        return 処理区分;
    }

    private RString 以降の判定処理を行わない判別(DbT7022ShoriDateKanriEntity 処理日付管理異動情報Entity,
            FlexibleYear 年度, RString 処理区分) {
        if (!不可.equals(処理区分)) {
            処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_異動所得情報抽出(年度);
            if (処理日付管理異動情報Entity == null) {
                処理区分 = 不可;
            } else {
                処理区分 = 可;
            }
            return 処理区分;
        } else {
            return 処理区分;
        }
    }
}
