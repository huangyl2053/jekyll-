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
import jp.co.ndensan.reams.db.dba.definition.message.DbaErrorMessages;
import jp.co.ndensan.reams.db.dba.definition.mybatisprm.hihokenshadaicho.HihokenshaShikakuShutokuMapperParameter;
import jp.co.ndensan.reams.db.dba.persistence.db.mapper.relate.hihokenshadaicho.IHihokenshaShikakuShutokuMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.HihokenshaDaicho;
import jp.co.ndensan.reams.db.dbz.definition.core.shikakuidojiyu.ShikakuShutokuJiyu;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT1001HihokenshaDaichoDac;
import jp.co.ndensan.reams.db.dbz.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.service.core.hihokenshanotsukiban.HihokenshanotsukibanFinder;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.AgeCalculator;
import jp.co.ndensan.reams.ua.uax.business.core.dateofbirth.IDateOfBirth;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.AgeArrivalDay;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.JuminJotai;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.SearchResult;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 *
 * 被保険者台帳管理（資格取得）情報を管理するサービスクラスです。
 *
 * @reamsid_L DBA-0520-010 lishengli
 */
public class HihokenshaShikakuShutokuManager {

    private static final int AGE_65 = 65;
    private static final int AGE_64 = 64;
    private static final int AGE_40 = 40;
    private static final int INT_4 = 4;
    private static final FlexibleDate ICHIGOSHIKAKUSHUTOKUYMD = new FlexibleDate("");
    private static final RString HIHOKENNSHAKUBUNCODE_1 = new RString("1");
    private static final RString HIHOKENNSHAKUBUNCODE_2 = new RString("2");
    private static final RString 枝番 = new RString("0001");
    private static final RString 被保険者番号 = new RString("被保険者番号");
    private final DbT1001HihokenshaDaichoDac dbT1001Dac;
    private final MapperProvider mapperProvider;
    private boolean checkFlg = false;

    /**
     * コンストラクタです。
     */
    HihokenshaShikakuShutokuManager() {
        this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        this.dbT1001Dac = InstanceProvider.create(DbT1001HihokenshaDaichoDac.class);

    }

    /**
     * テスト用コンストラクタです。
     *
     * @param DbT1001HihokenshaDaichoDac dbT1001Dac
     * @paramMapperProvider mapperProvider
     */
    HihokenshaShikakuShutokuManager(MapperProvider mapperProvider, DbT1001HihokenshaDaichoDac dbT1001Dac) {
        this.mapperProvider = mapperProvider;
        this.dbT1001Dac = dbT1001Dac;

    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuShutokuManager}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link HihokenshaShikakuShutokuManager}のインスタンス
     */
    public static HihokenshaShikakuShutokuManager createInstance() {
        return InstanceProvider.create(HihokenshaShikakuShutokuManager.class);
    }

    /**
     * 被保険者台帳管理リストを取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     * @return SearchResult<HihokenshaShutokuJyoho>　被保険者台帳管理リスト
     */
    @Transaction
    public SearchResult<HihokenshaShutokuJyoho> getHihokenshaShutokuJyoho(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号.toString()));
        List<HihokenshaShutokuJyoho> hihokenshaShutokuJyohoList = new ArrayList<>();
        IHihokenshaShikakuShutokuMapper hokenshamapper = mapperProvider.create(IHihokenshaShikakuShutokuMapper.class);
        HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.
                createParam_HokenshaDaicho(hihokenshaNo, shikibetsuCode);
        List<DbT1001HihokenshaDaichoEntity> entitylist = hokenshamapper.getHihokenshaShutokuJyoho(parameter);
        if (entitylist == null || entitylist.isEmpty()) {
            return SearchResult.of(Collections.<HihokenshaShutokuJyoho>emptyList(), 0, false);
        }
        for (DbT1001HihokenshaDaichoEntity entity : entitylist) {
            hihokenshaShutokuJyohoList.add(new HihokenshaShutokuJyoho(entity));
        }
        return SearchResult.of(hihokenshaShutokuJyohoList, 0, false);
    }

    /**
     * 被保険者台帳管理（資格取得）登録処理します。
     *
     * @param hihokenshaDaicho 被保険者台帳管理
     * @param 生年月日 当該識別対象の生年月日
     */
    @Transaction
    public void saveHihokenshaShutoku(HihokenshaDaicho hihokenshaDaicho, IDateOfBirth 生年月日) {
        requireNonNull(hihokenshaDaicho, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者台帳管理"));
        requireNonNull(生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当該識別対象の生年月日"));
        DbT1001HihokenshaDaichoEntity entity = hihokenshaDaicho.toEntity();
        HihokenshaNo hihokenshaNo = HihokenshanotsukibanFinder.createInstance().getHihokenshanotsukiban(entity.getShikibetsuCode());
        RString age = get年齢(生年月日, entity.getShikakuShutokuYMD());
        if (Integer.parseInt(age.toString()) >= AGE_65) {
            entity.setHihokennshaKubunCode(HIHOKENNSHAKUBUNCODE_1);
        } else if (Integer.parseInt(age.toString()) >= AGE_40 && Integer.parseInt(age.toString()) <= AGE_64) {
            entity.setHihokennshaKubunCode(HIHOKENNSHAKUBUNCODE_2);
            entity.setIchigoShikakuShutokuYMD(ICHIGOSHIKAKUSHUTOKUYMD);
        }
        entity.setHihokenshaNo(hihokenshaNo);
        entity.setEdaNo(getSaidaiEdaban(hihokenshaNo, entity.getIdoYMD()));
        entity.setLogicalDeletedFlag(false);
        dbT1001Dac.save(entity);
    }

    /**
     * 最大枝番を取得します。
     *
     * @param hihokenshaNo 被保険者番号
     * @param idoYMD 異動日
     * @return RString 最大枝番
     */
    @Transaction
    public RString getSaidaiEdaban(HihokenshaNo hihokenshaNo, FlexibleDate idoYMD) {
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号.toString()));
        requireNonNull(idoYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        IHihokenshaShikakuShutokuMapper hokenshamapper = mapperProvider.create(IHihokenshaShikakuShutokuMapper.class);
        HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter.createParam_HokenshaEdaban(hihokenshaNo, idoYMD);
        DbT1001HihokenshaDaichoEntity entity = hokenshamapper.getSaidaiEdaban(parameter);
        if (entity == null || entity.getEdaNo().isEmpty()) {
            return 枝番;
        } else {
            return new RString(String.valueOf(Integer.valueOf(entity.getEdaNo().toString().trim()) + 1)).padZeroToLeft(INT_4);
        }
    }

    /**
     * 最新データ情報を取得します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     * @return HihokenshaShutokuJyoho 被保険者台帳管理（資格取得）情報
     */
    @Transaction
    public HihokenshaShutokuJyoho getSaishinDeta(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        IHihokenshaShikakuShutokuMapper hokenshamapper = mapperProvider.create(IHihokenshaShikakuShutokuMapper.class);
        HihokenshaShikakuShutokuMapperParameter parameter = HihokenshaShikakuShutokuMapperParameter
                .createParam_HokenshaDaicho(hihokenshaNo, shikibetsuCode);
        DbT1001HihokenshaDaichoEntity entity = hokenshamapper.getSaishinDeta(parameter);
        if (entity == null) {
            return null;
        }
        return new HihokenshaShutokuJyoho(entity);
    }

    /**
     * 資格取得登録チェック処理します。
     *
     * @param 当該識別対象の生年月日 当該識別対象の生年月日
     * @param 資格取得日 資格取得日
     * @param 資格取得事由コード 資格取得事由コード
     */
    @Transaction
    public void shikakuShutokuTorokuCheck(IDateOfBirth 当該識別対象の生年月日, FlexibleDate 資格取得日, RString 資格取得事由コード) {
        requireNonNull(当該識別対象の生年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("当該識別対象の生年月日"));
        requireNonNull(資格取得日, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得日"));
        requireNonNull(資格取得事由コード, UrSystemErrorMessages.値がnull.getReplacedMessage("資格取得事由コード"));
        RString age = get年齢(当該識別対象の生年月日, 資格取得日);
        if (ShikakuShutokuJiyu.年齢到達.getコード().equals(資格取得事由コード)) {
            if (!(Integer.parseInt(age.toString()) >= AGE_65)) {
                throw new ApplicationException(DbaErrorMessages.資格取得日時点１号被保険者年齢でない.getMessage());
            }
        } else {
            if (!(Integer.parseInt(age.toString()) >= AGE_40)) {
                throw new ApplicationException(DbaErrorMessages.資格取得日時点２号被保険者年齢未到達.getMessage());
            }
        }
    }

    /**
     * 資格取得チェック処理します。
     *
     * @param shikibetsuCode 識別コード
     * @param hihokenshaNo 被保険者番号
     * @return boolean チェックフラグ （資格取得ならtrue、対象外ならfalse）
     */
    @Transaction
    public boolean shikakuShutokuCheck(ShikibetsuCode shikibetsuCode, HihokenshaNo hihokenshaNo) {
        requireNonNull(shikibetsuCode, UrSystemErrorMessages.値がnull.getReplacedMessage("識別コード"));
        requireNonNull(hihokenshaNo, UrSystemErrorMessages.値がnull.getReplacedMessage(被保険者番号.toString()));
        HihokenshaShutokuJyoho hihokenshashutokujyoho = getSaishinDeta(shikibetsuCode, hihokenshaNo);
        if (hihokenshashutokujyoho == null) {
            checkFlg = true;
        } else {
            if (!hihokenshashutokujyoho.get資格取得年月日().isEmpty() && !hihokenshashutokujyoho.get資格喪失年月日().isEmpty()) {
                checkFlg = true;
            } else if (hihokenshashutokujyoho.get資格喪失年月日().isEmpty()) {
                checkFlg = HIHOKENNSHAKUBUNCODE_2.equals(hihokenshashutokujyoho.get被保険者区分コード());
            }
        }
        return checkFlg;
    }

    private RString get年齢(IDateOfBirth dateOfBirth, FlexibleDate shikakuShutokuYMD) {
        AgeCalculator ageCalculator = new AgeCalculator(dateOfBirth, JuminJotai.住民, FlexibleDate.MAX, AgeArrivalDay.前日, shikakuShutokuYMD);
        return ageCalculator.get年齢();
    }
}
