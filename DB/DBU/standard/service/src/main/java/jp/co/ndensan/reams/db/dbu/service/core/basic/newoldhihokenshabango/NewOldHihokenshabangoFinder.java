/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.service.core.basic.newoldhihokenshabango;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbu.business.core.newoldhihokenshabango.NewOldHihokenshabango;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT7026ShinKyuHihokenshaNoHenkanDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 新旧被保険者番号変換するクラスです。
 *
 */
public class NewOldHihokenshabangoFinder {

    private static final String 旧市町村コード = "（旧）市町村コード";
    private static final String 新被保険者番号 = "（新）被保険者番号";
    private static final String 旧被保険者番号 = "（旧）被保険者番号";

    private final DbT7026ShinKyuHihokenshaNoHenkanDac dac;

    /**
     * コンストラクタです。
     */
    public NewOldHihokenshabangoFinder() {
        dac = InstanceProvider.create(DbT7026ShinKyuHihokenshaNoHenkanDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT7005RojinHokenJukyushaJohoDac}
     */
    NewOldHihokenshabangoFinder(DbT7026ShinKyuHihokenshaNoHenkanDac dac) {
        this.dac = dac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した
     */
    public static NewOldHihokenshabangoFinder createInstance() {
        return InstanceProvider.create(NewOldHihokenshabangoFinder.class);
    }

    /**
     * 旧被保険者番号の取得します。
     *
     * @param shinNo 新番号
     * @return NewOldHihokenshabango 新旧被保険者番号変換
     */
    @Transaction
    public NewOldHihokenshabango getOldHihokenshabangoFromNew(
            RString shinNo) {
        requireNonNull(shinNo, UrSystemErrorMessages.値がnull.getReplacedMessage("新番号"));
        if (shinNo.length() != 10) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage().replace(
                    新被保険者番号, String.valueOf(shinNo.length())));
        }
        List<DbT7026ShinKyuHihokenshaNoHenkanEntity> entityList = dac.get旧被保険者番号(shinNo);
        DbT7026ShinKyuHihokenshaNoHenkanEntity entity = new DbT7026ShinKyuHihokenshaNoHenkanEntity();
        if (1 < entityList.size()) {
            throw new ApplicationException(DbzErrorMessages.検索結果件数不正.getMessage());
        } else {
            if (0 != entityList.size()) {
                entity = entityList.get(0);
            }
            NewOldHihokenshabango newoldhihokenshabango = new NewOldHihokenshabango(entity);
            return newoldhihokenshabango;
        }
    }

    /**
     * 新被保険者番号の取得します。
     *
     * @param shichosonCode 市町村コード
     * @param kyuNo 旧番号
     * @return NewOldHihokenshabango 新旧被保険者番号変換
     */
    @Transaction
    public NewOldHihokenshabango getNewHihokenshabangoFromOld(
            LasdecCode shichosonCode,
            RString kyuNo) {
        requireNonNull(shichosonCode, UrSystemErrorMessages.値がnull.getReplacedMessage("市町村コード"));
        requireNonNull(kyuNo, UrSystemErrorMessages.値がnull.getReplacedMessage("旧番号"));
        if (shichosonCode.value().length() != 6) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage().replace(
                    旧市町村コード, String.valueOf(shichosonCode.value().length())));
        }
        if (kyuNo.length() != 10) {
            throw new ApplicationException(UrErrorMessages.桁数が不正.getMessage().replace(
                    旧被保険者番号, String.valueOf(kyuNo.length())));
        }
        List<DbT7026ShinKyuHihokenshaNoHenkanEntity> entityList = dac.get新被保険者番号(shichosonCode, kyuNo);
        if (0 == entityList.size() || entityList.isEmpty()) {
            throw new ApplicationException(UrErrorMessages.該当データなし.getMessage());
        } else {
            NewOldHihokenshabango newoldhihokenshabango = new NewOldHihokenshabango(entityList.get(0));
            return newoldhihokenshabango;
        }
    }
}
