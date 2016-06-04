/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.shotokujohotyushuturenkeitanitu;

import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeitanitu.ShotokuJohoBatchresultTanituParameter;
import jp.co.ndensan.reams.db.dbb.business.core.basic.shotokujohotyushuturenkeitanitu.ShotokuJohoTyushutuRenkeiTanituParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ51005_2_所得情報抽出・連携（単一他社）
 *
 * @reamsid_L DBB-1690-050 sunhui
 */
public class ShotokuJohoTyushutuRenkeitanitu {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    private static final RString 処理日付管理マスタ無し = new RString("3");
    private static final RString 遷移区分_0 = new RString("0");
    private static final RString 遷移区分_1 = new RString("1");
    private static final RString 不可 = new RString("2");
    private static final RString 可 = new RString("1");

    ShotokuJohoTyushutuRenkeitanitu() {
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    ShotokuJohoTyushutuRenkeitanitu(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShotokuJohoTyushutuRenkeitanitu}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShotokuJohoTyushutuRenkeitanitu}のインスタンス
     */
    public static ShotokuJohoTyushutuRenkeitanitu createInstance() {
        return InstanceProvider.create(ShotokuJohoTyushutuRenkeitanitu.class);
    }

    /**
     *
     * @param 市町村識別ID LasdecCode
     * @param 遷移区分 RString
     * @param 年度 FlexibleYear
     * @return 処理区分 RString
     */
    public RString getShoriKubun(LasdecCode 市町村識別ID, RString 遷移区分, FlexibleYear 年度) {
        RString 処理区分 = RString.EMPTY;
        YMDHMS 基準日時;
        DbT7022ShoriDateKanriEntity 処理日付管理異動情報Entity;
        if (遷移区分_0.equals(遷移区分)) {
            処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_当初所得情報抽出(年度, 市町村識別ID);
            if (処理日付管理異動情報Entity == null) {
                処理区分 = 処理日付管理マスタ無し;
            } else {
                基準日時 = 処理日付管理異動情報Entity.getKijunTimestamp();
                処理区分 = 基準日時1(基準日時);
            }
            return 処理区分;
        }
        if (遷移区分_1.equals(遷移区分)) {
            処理日付管理異動情報Entity = 処理日付管理Dac.select処理日付管理マスタ_当初所得情報抽出(年度, 市町村識別ID);
            if (処理日付管理異動情報Entity == null) {
                処理区分 = 不可;
                return 処理区分;
            } else {
                基準日時 = 処理日付管理異動情報Entity.getKijunTimestamp();
                基準日時2(基準日時, 処理区分);
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
     * @param 処理区分 RString
     * @param parameter ShotokuJohoTyushutuRenkeiKoikiParameter
     * @return ShotokuJohoBatchresultParameter createShotokuJohoParameter
     */
    public ShotokuJohoBatchresultTanituParameter createShotokuJohoParameter(ShotokuJohoTyushutuRenkeiTanituParameter parameter, RString 処理区分) {
        ShotokuJohoBatchresultTanituParameter result = new ShotokuJohoBatchresultTanituParameter();
        result.set処理年度(parameter.get処理年度());
        result.set所得情報取込処理状態(parameter.get所得情報取込処理状態());
        result.set出力順ID(parameter.get出力順ID());
        result.set帳票ID(new ReportId("DBB200008_KaigoHokenShotokuJohoIchiran"));
        result.set共有ファイル名(parameter.get共有ファイル名());
        result.set共有ファイルID(parameter.get共有ファイルID());
        result.set処理区分(処理区分);
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

    private RString 基準日時2(YMDHMS 基準日時, RString 処理区分) {
        if (基準日時 != null && !基準日時.isEmpty()) {
            処理区分 = 可;
        } else {
            処理区分 = 不可;
        }
        return 処理区分;
    }
}
