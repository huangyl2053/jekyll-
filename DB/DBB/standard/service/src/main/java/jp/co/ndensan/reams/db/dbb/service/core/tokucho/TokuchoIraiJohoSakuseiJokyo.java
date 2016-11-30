/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.service.core.tokucho;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.definition.core.tokucho.TokuchoHosokuMonth;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBB;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.business.core.basic.ShoriDateKanri;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.db.dbx.persistence.db.basic.DbT7022ShoriDateKanriDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 特徴依頼情報作成状況のビジネスクラスです。
 *
 * @reamsid_L DBB-0660-040 cuilin
 */
public class TokuchoIraiJohoSakuseiJokyo {

    private final DbT7022ShoriDateKanriDac dac;

    private static final RString 連番_4月捕捉 = new RString("0001");
    private static final RString 連番_6月捕捉 = new RString("0004");
    private static final RString 連番_8月捕捉 = new RString("0005");
    private static final RString 連番_10月捕捉 = new RString("0006");
    private static final RString 連番_前年度2月捕捉 = new RString("0002");
    private static final RString 連番_前年度12月捕捉 = new RString("0001");
    private static final RString 連番 = new RString("0006");
    private static final RString 処理枝番 = new RString("0001");

    /**
     * コンストラクタです
     */
    public TokuchoIraiJohoSakuseiJokyo() {
        this.dac = InstanceProvider.create(DbT7022ShoriDateKanriDac.class);
    }

    /**
     * コンストラクタです。
     *
     * @param dac DbT7022ShoriDateKanriDac
     */
    TokuchoIraiJohoSakuseiJokyo(DbT7022ShoriDateKanriDac dac) {
        this.dac = dac;
    }

    /**
     * にて生成した{@link TokuchoIraiJohoSakuseiJokyo}のインスタンスを返します。
     *
     * @return FukaKeisan
     */
    public static TokuchoIraiJohoSakuseiJokyo createInstance() {
        return InstanceProvider.create(TokuchoIraiJohoSakuseiJokyo.class);
    }

    /**
     * 捕捉月別_作成状況取得メソッド
     *
     * @param 捕捉月 RString
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> find処理状況Of(RString 捕捉月) {
        RString 処理名;
        RString 年度内連番 = RString.EMPTY;
        if (TokuchoHosokuMonth.特徴4月捕捉.getコード().equals(捕捉月)) {
            処理名 = ShoriName.特徴依頼情報作成.get名称();
            年度内連番 = 連番_4月捕捉;
        } else {
            処理名 = ShoriName.特徴異動情報作成.get名称();
            if (TokuchoHosokuMonth.特徴6月捕捉.getコード().equals(捕捉月)) {
                年度内連番 = 連番_6月捕捉;
            } else if (TokuchoHosokuMonth.特徴8月捕捉.getコード().equals(捕捉月)) {
                年度内連番 = 連番_8月捕捉;
            } else if (TokuchoHosokuMonth.特徴10月捕捉.getコード().equals(捕捉月)) {
                年度内連番 = 連番_10月捕捉;
            } else if (TokuchoHosokuMonth.特徴12月捕捉.getコード().equals(捕捉月)) {
                年度内連番 = 連番_前年度12月捕捉;
            } else if (TokuchoHosokuMonth.特徴2月捕捉.getコード().equals(捕捉月)) {
                年度内連番 = 連番_前年度2月捕捉;
            }
        }
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        List<ShoriDateKanri> 処理状況 = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> 処理状況の情報 = dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課, 処理名, 処理枝番, 調定年度, 年度内連番);
        for (DbT7022ShoriDateKanriEntity entity : 処理状況の情報) {
            処理状況.add(new ShoriDateKanri(entity));
        }
        return 処理状況;
    }

    /**
     * 捕捉月取得メソッド
     *
     * @return RString
     */
    public RString get最新処理の捕捉月() {
        FlexibleYear 調定年度 = new FlexibleYear(DbBusinessConfig.get(ConfigNameDBB.日付関連_調定年度,
                RDate.getNowDate(), SubGyomuCode.DBB介護賦課).toString());
        List<RString> 処理名リスト = new ArrayList<>();
        処理名リスト.add(ShoriName.特徴依頼情報作成.get名称());
        処理名リスト.add(ShoriName.特徴異動情報作成.get名称());
        DbT7022ShoriDateKanriEntity entity = dac.select最新の基準日(調定年度, 処理名リスト);
        if (entity == null) {
            throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
        }
        if (ShoriName.特徴依頼情報作成.get名称().equals(entity.getShoriName())) {
            return TokuchoHosokuMonth.特徴4月捕捉.getコード();
        } else if (ShoriName.特徴異動情報作成.get名称().equals(entity.getShoriName())) {
            if (連番_前年度12月捕捉.equals(entity.getNendoNaiRenban())) {
                return TokuchoHosokuMonth.特徴12月捕捉.getコード();
            } else if (連番_前年度2月捕捉.equals(entity.getNendoNaiRenban())) {
                return TokuchoHosokuMonth.特徴2月捕捉.getコード();
            } else if (連番_6月捕捉.equals(entity.getNendoNaiRenban())) {
                return TokuchoHosokuMonth.特徴6月捕捉.getコード();
            } else if (連番_8月捕捉.equals(entity.getNendoNaiRenban())) {
                return TokuchoHosokuMonth.特徴8月捕捉.getコード();
            } else if (連番_10月捕捉.equals(entity.getNendoNaiRenban())) {
                return TokuchoHosokuMonth.特徴10月捕捉.getコード();
            }
        }
        throw new ApplicationException(UrErrorMessages.対象データなし.getMessage().evaluate());
    }

    /**
     * 年度内_作成状況取得メソッド
     *
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> find年度内処理状況() {
        FlexibleYear 調定年度 = FlexibleDate.getNowDate().getYear();
        List<RString> 処理名リスト = new ArrayList<>();
        処理名リスト.add(ShoriName.特徴依頼情報作成.get名称());
        処理名リスト.add(ShoriName.特徴異動情報作成.get名称());
        List<DbT7022ShoriDateKanriEntity> entityList = dac.select処理状況(調定年度, 処理名リスト, SubGyomuCode.DBB介護賦課);
        List<ShoriDateKanri> 年度内処理状況 = new ArrayList<>();
        for (DbT7022ShoriDateKanriEntity entity : entityList) {
            年度内処理状況.add(new ShoriDateKanri(entity));
        }
        return 年度内処理状況;
    }

    /**
     * 依頼金額計算作成状況取得メソッド
     *
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> find依頼金額計算処理状況() {
        FlexibleYear 調定年度 = FlexibleDate.getNowDate().getYear();
        List<ShoriDateKanri> 処理状況 = new ArrayList<>();
        List<DbT7022ShoriDateKanriEntity> 処理状況の情報
                = dac.selectBySomeKeys(SubGyomuCode.DBB介護賦課, ShoriName.依頼金額計算.get名称(), 処理枝番, 調定年度, 連番);
        for (DbT7022ShoriDateKanriEntity entity : 処理状況の情報) {
            処理状況.add(new ShoriDateKanri(entity));
        }
        return 処理状況;
    }

    /**
     * 依頼金額計算状況リスト取得メソッド
     *
     * @param 調定年度 FlexibleYear
     * @return List<ShoriDateKanri>
     */
    public List<ShoriDateKanri> find依頼金額計算処理状況リスト(FlexibleYear 調定年度) {
        List<ShoriDateKanri> 処理状況 = new ArrayList<>();
        List<RString> 処理名リスト = new ArrayList<>();
        処理名リスト.add(ShoriName.依頼金額計算.get名称());
        List<DbT7022ShoriDateKanriEntity> 処理状況の情報 = dac.select処理状況(調定年度, 処理名リスト, SubGyomuCode.DBB介護賦課);
        for (DbT7022ShoriDateKanriEntity entity : 処理状況の情報) {
            処理状況.add(new ShoriDateKanri(entity));
        }
        return 処理状況;
    }
}
