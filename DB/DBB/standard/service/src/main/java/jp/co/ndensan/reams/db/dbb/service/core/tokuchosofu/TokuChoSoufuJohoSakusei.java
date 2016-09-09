/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokuchosofu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbb.business.core.basic.tokuchosofu.TokuChoSoufuJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB211001.DBB211001_TokuchoSofuJohoSakuseiParameter;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * ビジネス設計_DBBBZ82001_1_特徴送付情報作成
 *
 * @reamsid_L DBB-1840-030 zhangrui
 *
 */
public class TokuChoSoufuJohoSakusei {

    private final DbT7022ShoriDateKanriDac 処理日付管理Dac;

    private static final RString 対象月_1月 = new RString("1月");
    private static final RString 対象月_2月 = new RString("2月");
    private static final RString 対象月_3月 = new RString("3月");
    private static final RString 対象月_4月 = new RString("4月");
    private static final RString 対象月_5月 = new RString("5月");
    private static final RString 対象月_6月 = new RString("6月");
    private static final RString 対象月_7月 = new RString("7月");
    private static final RString 対象月_8月 = new RString("8月");
    private static final RString 対象月_9月 = new RString("9月");
    private static final RString 対象月_10月 = new RString("10月");
    private static final RString 対象月_11月 = new RString("11月");
    private static final RString 対象月_12月 = new RString("12月");
    private static final RString 年度内連番_1 = new RString("0001");
    private static final RString 年度内連番_2 = new RString("0002");
    private static final RString 年度内連番_3 = new RString("0003");
    private static final RString 年度内連番_5 = new RString("0005");
    private static final RString 年度内連番_6 = new RString("0006");
    private static final RString 年度内連番_7 = new RString("0007");
    private static final RString 年度内連番_8 = new RString("0008");
    private static final RString 年度内連番_9 = new RString("0009");
    private static final RString 年度内連番_10 = new RString("0010");
    private static final RString 年度内連番_11 = new RString("0011");
    private static final RString 年度内連番_12 = new RString("0012");
    private static final Map<RString, RString> 対象月連番MAP = new HashMap<>();

    private static final RString 帳票ID_1 = new RString("DBB200019_TokubetsuChoshuIraiJohoIchiran");
    private static final RString 帳票ID_2 = new RString("DBB200021_TokubetsuChoshuIdojohoIchiran");
    private static final RString 件数表帳票ID_1 = new RString("DBB200020_TokubetsuChoshuIraiJohoKensuhyo");
    private static final RString 件数表帳票ID_2 = new RString("DBB200022_TokubetsuChoshuIdojohoKensuhyo");

    private static final RString 賦課年度メッセージ = new RString("賦課年度");
    private static final RString バッチパラメータメッセージ = new RString("バッチパラメータ");
    private static final RString 処理対象月メッセージ = new RString("処理対象月");

    /**
     * コンストラクタです。
     */
    public TokuChoSoufuJohoSakusei() {
        init対象月連番Map();
        this.処理日付管理Dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param 処理日付管理Dac DbT7022ShoriDateKanriDac
     */
    public TokuChoSoufuJohoSakusei(DbT7022ShoriDateKanriDac 処理日付管理Dac) {
        init対象月連番Map();
        this.処理日付管理Dac = 処理日付管理Dac;
    }

    private void init対象月連番Map() {
        対象月連番MAP.put(年度内連番_1, 対象月_4月);
        対象月連番MAP.put(年度内連番_2, 対象月_5月);
        対象月連番MAP.put(年度内連番_3, 対象月_6月);
        対象月連番MAP.put(年度内連番_5, 対象月_8月);
        対象月連番MAP.put(年度内連番_6, 対象月_9月);
        対象月連番MAP.put(年度内連番_7, 対象月_10月);
        対象月連番MAP.put(年度内連番_8, 対象月_11月);
        対象月連番MAP.put(年度内連番_9, 対象月_12月);
        対象月連番MAP.put(年度内連番_10, 対象月_1月);
        対象月連番MAP.put(年度内連番_11, 対象月_2月);
        対象月連番MAP.put(年度内連番_12, 対象月_3月);
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link TokuChoSoufuJohoSakusei}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link TokuChoSoufuJohoSakusei}のインスタンス
     */
    public static TokuChoSoufuJohoSakusei createInstance() {
        return InstanceProvider.create(TokuChoSoufuJohoSakusei.class);
    }

    /**
     * 処理日時の取得
     *
     * @param 賦課年度 FlexibleYear
     * @return Map<RString, YMDHMS>
     */
    public Map<RString, YMDHMS> getShoriDate(FlexibleYear 賦課年度) {
        requireNonNull(賦課年度, UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度メッセージ.toString()));
        Map<RString, YMDHMS> 処理日時Map = new HashMap<>();
        DbT7022ShoriDateKanriEntity 特徴依頼情報作成 = 処理日付管理Dac.get特徴依頼情報作成の基準日時含みエンティティ(
                SubGyomuCode.DBB介護賦課, ShoriName.特徴依頼情報作成.get名称(), 賦課年度, 年度内連番_1);
        if (null != 特徴依頼情報作成) {
            処理日時Map.put(対象月_7月, 特徴依頼情報作成.getKijunTimestamp());
        } else {
            処理日時Map.put(対象月_7月, null);
        }
        List<DbT7022ShoriDateKanriEntity> entityList = 処理日付管理Dac.selectShorikubun(SubGyomuCode.DBB介護賦課,
                ShoriName.特徴異動情報作成.get名称(), 賦課年度);
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            RString 年度内連番 = entity.getNendoNaiRenban();
            if (対象月連番MAP.containsKey(年度内連番)) {
                処理日時Map.put(対象月連番MAP.get(年度内連番), entity.getKijunTimestamp());
            }
        }
        for (RString 対象月 : 対象月連番MAP.values()) {
            if (!処理日時Map.containsKey(対象月)) {
                処理日時Map.put(対象月, null);
            }
        }
        return 処理日時Map;
    }

    /**
     * バッチ用パラメータ作成
     *
     * @param divParam TokuChoSoufuJohoSakuseiParameter
     * @return DBB211001_TokuchoSofuJohoSakuseiParameter
     */
    public DBB211001_TokuchoSofuJohoSakuseiParameter createTokuChoSoufuJohoParameter(TokuChoSoufuJohoSakuseiParameter divParam) {
        requireNonNull(divParam, UrSystemErrorMessages.値がnull.getReplacedMessage(バッチパラメータメッセージ.toString()));
        requireNonNull(divParam.get賦課年度(), UrSystemErrorMessages.値がnull.getReplacedMessage(賦課年度メッセージ.toString()));
        requireNonNull(divParam.get処理対象月(), UrSystemErrorMessages.値がnull.getReplacedMessage(処理対象月メッセージ.toString()));
        DBB211001_TokuchoSofuJohoSakuseiParameter parameter = new DBB211001_TokuchoSofuJohoSakuseiParameter();
        parameter.set賦課年度(divParam.get賦課年度());
        RString 処理対象月 = divParam.get処理対象月();
        parameter.set処理対象月(処理対象月);
        if (対象月_7月.equals(処理対象月)) {
            parameter.set帳票ID(帳票ID_1);
            parameter.set件数表帳票ID(件数表帳票ID_1);
        } else {
            parameter.set帳票ID(帳票ID_2);
            parameter.set件数表帳票ID(件数表帳票ID_2);
        }
        parameter.set出力順ID(divParam.get出力順ID());
        return parameter;
    }

}
