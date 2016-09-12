/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.business.core.basic.JukyushaIdoRenrakuhyo;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者異動送付を管理するクラスです。
 */
public class JukyushaIdoRenrakuhyoManager {

    private final DbT3001JukyushaIdoRenrakuhyoDac dac;

    /**
     * コンストラクタです。
     */
    public JukyushaIdoRenrakuhyoManager() {
        dac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT3001JukyushaIdoRenrakuhyoDac}
     */
    JukyushaIdoRenrakuhyoManager(DbT3001JukyushaIdoRenrakuhyoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する受給者異動送付を返します。
     *
     * @param 異動年月日 IdoYMD
     * @param 異動区分コード IdoKubunCode
     * @param 受給者異動事由 JukyushaIdoJiyu
     * @param 証記載保険者番号 ShoKisaiHokenshaNo
     * @param 被保険者番号 HiHokenshaNo
     * @param 履歴番号 RirekiNo
     * @return JukyushaIdoRenrakuhyo
     */
    @Transaction
    public JukyushaIdoRenrakuhyo get受給者異動送付(
            FlexibleDate 異動年月日,
            RString 異動区分コード,
            RString 受給者異動事由,
            ShoKisaiHokenshaNo 証記載保険者番号,
            HihokenshaNo 被保険者番号,
            int 履歴番号) {
        requireNonNull(異動年月日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動年月日"));
        requireNonNull(異動区分コード, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分コード"));
        requireNonNull(受給者異動事由, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動事由"));
        requireNonNull(証記載保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("証記載保険者番号"));
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(履歴番号, UrSystemErrorMessages.値がnull.getReplacedMessage("履歴番号"));

        DbT3001JukyushaIdoRenrakuhyoEntity entity = dac.selectByKey(
                異動年月日,
                異動区分コード,
                受給者異動事由,
                証記載保険者番号,
                被保険者番号,
                履歴番号);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new JukyushaIdoRenrakuhyo(entity);
    }

    /**
     * 受給者異動送付を全件返します。
     *
     * @return List<JukyushaIdoRenrakuhyo>
     */
    @Transaction
    public List<JukyushaIdoRenrakuhyo> get受給者異動送付一覧() {
        List<JukyushaIdoRenrakuhyo> businessList = new ArrayList<>();

        for (DbT3001JukyushaIdoRenrakuhyoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new JukyushaIdoRenrakuhyo(entity));
        }

        return businessList;
    }

    /**
     * 受給者異動連絡票情報を全件返します。
     *
     * @param 被保険者番号 被保険者番号
     * @param 異動日 異動日
     * @return JukyushaIdoRenrakuhyo
     */
    @Transaction
    public JukyushaIdoRenrakuhyo get受給者異動連絡票情報(RString 被保険者番号, RString 異動日) {
        DbT3001JukyushaIdoRenrakuhyoEntity entity = dac.selectAll受給者異動連絡票情報(被保険者番号, 異動日);
        if (entity != null) {
            return new JukyushaIdoRenrakuhyo(entity);
        }
        return null;
    }

    /**
     * 受給者異動送付{@link JukyushaIdoRenrakuhyo}を保存します。
     *
     * @param 受給者異動送付 {@link JukyushaIdoRenrakuhyo}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save受給者異動送付(JukyushaIdoRenrakuhyo 受給者異動送付) {
        requireNonNull(受給者異動送付, UrSystemErrorMessages.値がnull.getReplacedMessage("受給者異動送付"));
        if (!受給者異動送付.hasChanged()) {
            return false;
        }
        return 1 == dac.save(受給者異動送付.toEntity());
    }
}
