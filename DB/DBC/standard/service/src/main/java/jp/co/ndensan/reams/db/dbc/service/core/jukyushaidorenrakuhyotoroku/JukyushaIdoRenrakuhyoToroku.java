/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.jukyushaidorenrakuhyotoroku;

import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3001JukyushaIdoRenrakuhyoEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.basic.DbT3001JukyushaIdoRenrakuhyoDac;
import jp.co.ndensan.reams.db.dbz.definition.message.DbzErrorMessages;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.ApplicationException;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 受給者異動連絡票（追加）登録です。
 *
 * @reamsid_L DBC-2100-030 jiangzongyue
 */
public class JukyushaIdoRenrakuhyoToroku {

    //private final MapperProvider mapperProvider;
    private final DbT3001JukyushaIdoRenrakuhyoDac dbT3001JukyushaIdoRenrakuhyoDac;
    private static final RString ZERO = new RString("0");
    private static final RString ONE = new RString("1");
    private static final RString TWO = new RString("2");
    private static final RString THREE = new RString("3");

    /**
     * コンストラクタです。
     */
    JukyushaIdoRenrakuhyoToroku() {
        //this.mapperProvider = InstanceProvider.create(MapperProvider.class);
        dbT3001JukyushaIdoRenrakuhyoDac = InstanceProvider.create(DbT3001JukyushaIdoRenrakuhyoDac.class);
    }

    /**
     * 単体テスト用のコンストラクタです。
     *
     */
    JukyushaIdoRenrakuhyoToroku(DbT3001JukyushaIdoRenrakuhyoDac dbT3001JukyushaIdoRenrakuhyoDac) {
        //this.mapperProvider = mapperProvider;
        this.dbT3001JukyushaIdoRenrakuhyoDac = dbT3001JukyushaIdoRenrakuhyoDac;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoToroku}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link JukyushaIdoRenrakuhyoToroku}のインスタンス
     */
    public static JukyushaIdoRenrakuhyoToroku createInstance() {
        return InstanceProvider.create(JukyushaIdoRenrakuhyoToroku.class);
    }

    /**
     * 世受給者異動情報登録処理取得します。
     *
     * @param 被保険者番号 {@link JukyushaIdoRenrakuhyoTorokuMybatisParameter}
     * @param 異動日 {@link JukyushaIdoRenrakuhyoTorokuMybatisParameter}
     * @param 異動区分 異動区分
     * @return RString
     */
    @Transaction
    public RString regJukyushaIdoJoho(RString 被保険者番号, RDate 異動日, RString 異動区分) {
        requireNonNull(被保険者番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保険者番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));
        requireNonNull(異動区分, UrSystemErrorMessages.値がnull.getReplacedMessage("異動区分"));
        //IJukyushaIdoRenrakuhyoTorokuMapper mapper = mapperProvider.create(IJukyushaIdoRenrakuhyoTorokuMapper.class);
        List<DbT3001JukyushaIdoRenrakuhyoEntity> list = dbT3001JukyushaIdoRenrakuhyoDac.selectcount受給者異動送付テーブルを検索して既存の異動日を判断(被保険者番号, 異動日);
        //int count = mapper.count受給者異動送付テーブルを検索して既存の異動日を判断
        //(new JukyushaIdoRenrakuhyoTorokuMybatisParameter(被保険者番号, 異動日, RString.EMPTY, RString.EMPTY));
        if (0 != list.size()) {
            throw new ApplicationException(DbzErrorMessages.理由付き登録不可.getMessage().replace("既存の異動日"));
        } else {
            DbT3001JukyushaIdoRenrakuhyoEntity entity = dbT3001JukyushaIdoRenrakuhyoDac.select直近レコードを取得して判断(被保険者番号, 異動日);
            //RString idoKubunCode = mapper.直近レコードを取得して判断(new JukyushaIdoRenrakuhyoTorokuMybatisParameter(被保険者番号, 異動日, RString.EMPTY, RString.EMPTY));
            if ((ONE.equals(異動区分) && THREE.equals(entity.getIdoKubunCode()))
                    || (TWO.equals(異動区分) && (ONE.equals(entity.getIdoKubunCode()) || TWO.equals(entity.getIdoKubunCode())))
                    || (THREE.equals(異動区分) && (ONE.equals(entity.getIdoKubunCode()) || TWO.equals(entity.getIdoKubunCode())))) {
                return ONE;
            } else if ((ONE.equals(異動区分) && !THREE.equals(entity.getIdoKubunCode()))
                    || (TWO.equals(異動区分) && (!ONE.equals(entity.getIdoKubunCode()) && !TWO.equals(entity.getIdoKubunCode())))
                    || (THREE.equals(異動区分) && (!ONE.equals(entity.getIdoKubunCode()) && !TWO.equals(entity.getIdoKubunCode())))) {
                return ZERO;
            }
        }
        return null;
    }

    /**
     * 登録した受給者異動情報の取得します。
     *
     * @param 被保番号 {@link JukyushaIdoRenrakuhyoTorokuMybatisParameter}
     * @param 異動日 {@link JukyushaIdoRenrakuhyoTorokuMybatisParameter}
     * @return JukyushaIdoRenrakuhyoTorokuEntity
     */
    @Transaction
    public List<DbT3001JukyushaIdoRenrakuhyoEntity> editJukyushaIdoRenrakuhyo(RString 被保番号, RDate 異動日) {
        requireNonNull(被保番号, UrSystemErrorMessages.値がnull.getReplacedMessage("被保番号"));
        requireNonNull(異動日, UrSystemErrorMessages.値がnull.getReplacedMessage("異動日"));

        //IJukyushaIdoRenrakuhyoTorokuMapper mapper = mapperProvider.create(IJukyushaIdoRenrakuhyoTorokuMapper.class);
        //return mapper.登録した受給者異動情報の取得(new JukyushaIdoRenrakuhyoTorokuMybatisParameter(RString.EMPTY, 異動日, RString.EMPTY, 被保番号));
        return dbT3001JukyushaIdoRenrakuhyoDac.select登録した受給者異動情報の取得(被保番号, 異動日);
    }
}
