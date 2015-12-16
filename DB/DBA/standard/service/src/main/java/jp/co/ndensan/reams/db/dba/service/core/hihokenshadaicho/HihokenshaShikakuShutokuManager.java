/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.service.core.hihokenshadaicho;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dba.business.core.hihokenshadaicho.HihokenshaShutokuJyoho;
import jp.co.ndensan.reams.db.dba.definition.mybatis.param.hihokenshadaicho.HihokenshaShikakuShutokuMapperParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.basic.hihokenshadaicho.HihokenshaShikakuShutokuMapper;
import jp.co.ndensan.reams.db.dbu.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者台帳管理（資格取得）情報を管理するサービスクラスです。
 */
public class HihokenshaShikakuShutokuManager {

    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final MapperProvider mapperProvider;
    private static final int AGE_65 = 65;
    private static final int AGE_64 = 64;
    private static final int AGE_40 = 40;
    private static final FlexibleDate ICHIGOSHIKAKUSHUTOKUYMD = new FlexibleDate("");
    private static final RString HIHOKENNSHAKUBUNCODE_1 = new RString("1");
    private static final RString HIHOKENNSHAKUBUNCODE_2 = new RString("2");
    private static final RString 枝番 = new RString("0001");
    private static RString 年齢到達_事由コード = new RString("02");
    private static boolean chickflg = false;
    private static HihokenshaNo hihokenshaNo;
    private static ShikibetsuCode shikibetsuCode;
    private static FlexibleDate idoYMD;
    private static RString edaNo;
    private static FlexibleDate shikakuShutokuYMD;

    /**
     * コンストラクタです。
     */
    HihokenshaShikakuShutokuManager() {
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT1001HihokenshaDaichoDac dbT1001Dac
     * @paramMapperProvider mapperProvider
     */
    HihokenshaShikakuShutokuManager(DbT1001HihokenshaDaichoDac dbT1001Dac, MapperProvider mapperProvider) {
        this.dbT1001Dac = dbT1001Dac;
        this.mapperProvider = mapperProvider;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuShutokuManager}のインスタンスを返します。
     *
     * @return
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuShutokuManager}のインスタンス
     */
    public static HihokenshaShikakuShutokuManager createInstance() {
        return InstanceProvider.create(HihokenshaShikakuShutokuManager.class);
    }

    /**
     * 被保険者台帳管理リストを取得します。
     *
     * @param parameter　被保険者台帳管理のパラメータ
     * @return SearchResult<HihokenshaShutokuJyoho>　被保険者台帳管理リスト
     */
    @Transaction
    public SearchResult<HihokenshaShutokuJyoho> getHihokenshaShutokuJyoho(HihokenshaShikakuShutokuMapperParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理のパラメータ"));
        List<HihokenshaShutokuJyoho> hihokenshaShutokuJyohoList = new ArrayList<>();
        HihokenshaShikakuShutokuMapper hokenshamapper = mapperProvider.create(HihokenshaShikakuShutokuMapper.class);
        List<DbT1001HihokenshaDaichoEntity> entitylist = hokenshamapper.getHihokenshaShutokuJyoho(parameter);
        if (entitylist == null || entitylist.isEmpty()) {
            return SearchResult.of(Collections.< HihokenshaShutokuJyoho>emptyList(), 0, false);
        }
        for (DbT1001HihokenshaDaichoEntity entity : entitylist) {
            hihokenshaShutokuJyohoList.add(new HihokenshaShutokuJyoho(entity));
        }
        return SearchResult.of(hihokenshaShutokuJyohoList, 0, false);
    }

    /**
     * 保険者情報リストを取得します。
     *
     * @param entity　被保険者台帳管理（資格取得）
     * @param 生年月日　当該識別対象の生年月日
     */
    @Transaction
    public void saveHihokenshaShutoku(DbT1001HihokenshaDaichoEntity entity, IDateOfBirth 生年月日) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理（資格取得）Entity"));
        shikibetsuCode = entity.getShikibetsuCode();
        idoYMD = entity.getIdoYMD();
        hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(shikibetsuCode);
        HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaEdaban(hihokenshaNo, idoYMD);
        edaNo = getSaidaiEdaban(parameter);
        shikakuShutokuYMD = entity.getShikakuShutokuYMD();
        RString age = get年齢(生年月日, shikakuShutokuYMD);
        if (Integer.parseInt(age.toString()) >= AGE_65) {
            entity.setHihokennshaKubunCode(HIHOKENNSHAKUBUNCODE_1);
        } else if (Integer.parseInt(age.toString()) <= AGE_64 && Integer.parseInt(age.toString()) >= AGE_40) {
            entity.setHihokennshaKubunCode(HIHOKENNSHAKUBUNCODE_2);
            entity.setIchigoShikakuShutokuYMD(ICHIGOSHIKAKUSHUTOKUYMD);
        }
        entity.setHihokenshaNo(hihokenshaNo);
        entity.setEdaNo(edaNo);
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
    }

    /**
     * 最大枝番を取得します。
     *
     * @param parameter　被保険者台帳管理のパラメータ
     * @return RString 最大枝番
     */
    @Transaction
    public RString getSaidaiEdaban(HihokenshaShikakuShutokuMapperParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理のパラメータ"));
        HihokenshaShikakuShutokuMapper hokenshamapper = mapperProvider.create(HihokenshaShikakuShutokuMapper.class);
        DbT1001HihokenshaDaichoEntity entity = hokenshamapper.getSaidaiEdaban(parameter);
        if (entity == null || entity.getEdaNo().isEmpty()) {
            return 枝番;
        } else {
            return new RString(String.valueOf(Integer.valueOf(entity.getEdaNo().toString().trim()) + 1));
        }
    }

    /**
     * 最新データ情報を取得します。
     *
     * @param parameter　被保険者台帳管理のパラメータ
     * @return HihokenshaShutokuJyoho 最新データ情報
     */
    @Transaction
    public HihokenshaShutokuJyoho getSaishinDeta(HihokenshaShikakuShutokuMapperParameter parameter) {
        requireNonNull(parameter, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理のパラメータ"));
        HihokenshaShikakuShutokuMapper hokenshamapper = mapperProvider.create(HihokenshaShikakuShutokuMapper.class);
        DbT1001HihokenshaDaichoEntity entity = hokenshamapper.getSaishinDeta(parameter);
        if (entity == null) {
            return null;
        }
        return new HihokenshaShutokuJyoho(entity);
    }

    /**
     * 資格取得登録チェック処理。
     *
     * @param 当該識別対象の生年月日　当該識別対象の生年月日
     * @param 資格取得日　資格取得日
     * @param 資格取得事由コード　資格取得事由コード
     * @return boolean　チェックフラグ
     */
    @Transaction
    public boolean shikakuShutokuTorokuCheck(IDateOfBirth 当該識別対象の生年月日, FlexibleDate 資格取得日, RString 資格取得事由コード) {
        RString age = get年齢(当該識別対象の生年月日, 資格取得日);
        // TODO 李　QA152あります年齢到達_事由コード不明です。2015/12/17
//        年齢到達_事由コード = CodeMaster.getCode(SubGyomuCode.URZ業務共通_共通系, new CodeShubetsu("0117")).get(0).getコード().value();
        if (年齢到達_事由コード.equals(資格取得事由コード)) {
            return Integer.parseInt(age.toString()) >= AGE_65;
        } else {
            return Integer.parseInt(age.toString()) >= AGE_40;
        }
    }

    /**
     * 資格取得チェック処理。
     *
     * @param parameter　被保険者台帳管理のパラメータ
     * @return boolean　チェックフラグ
     */
    @Transaction
    public boolean shikakuShutokuCheck(HihokenshaShikakuShutokuMapperParameter parameter) {
        HihokenshaShutokuJyoho hihokenshashutokujyoho = getSaishinDeta(parameter);
        if (hihokenshashutokujyoho == null) {
            chickflg = true;
        } else {
            if (!hihokenshashutokujyoho.get資格取得年月日().isEmpty() && !hihokenshashutokujyoho.get資格喪失年月日().isEmpty()) {
                chickflg = true;
            } else if (hihokenshashutokujyoho.get資格喪失年月日().isEmpty()) {
                chickflg = HIHOKENNSHAKUBUNCODE_2.equals(hihokenshashutokujyoho.get被保険者区分コード());
            }
        }
        return chickflg;
    }

    private RString get年齢(IDateOfBirth dateOfBirth, FlexibleDate shikakuShutokuYMD) {
        AgeCalculator ageCalculator = new AgeCalculator(dateOfBirth, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, shikakuShutokuYMD);
        return ageCalculator.get年齢();
    }
}
