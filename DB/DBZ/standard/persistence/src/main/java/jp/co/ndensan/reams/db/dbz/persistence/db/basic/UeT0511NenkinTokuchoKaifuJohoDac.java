/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.persistence.db.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.gyomuCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.hosokuTsuki;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.kisoNenkinNo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.koseiCityCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.nenkinCode;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.renban;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.shoriNendo;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.shoriTaishoYM;
import static jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJoho.tsuchiNaiyoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.core.mybatis.SqlSession;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.DbAccessorNormalType;
import jp.co.ndensan.reams.uz.uza.util.db.ITrueFalseCriteria;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.and;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.eq;
import static jp.co.ndensan.reams.uz.uza.util.db.Restrictions.or;
import jp.co.ndensan.reams.uz.uza.util.db.util.DbAccessors;
import jp.co.ndensan.reams.uz.uza.util.di.InjectSession;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 年金特徴回付情報（介護継承）のデータアクセスクラスです。
 *
 * @reamsid_L DBZ-9999-022 yangchenbing
 */
public class UeT0511NenkinTokuchoKaifuJohoDac implements ISaveable<UeT0511NenkinTokuchoKaifuJohoEntity> {

    @InjectSession
    private SqlSession session;

    private enum Constants {

        業務コード,
        処理年度,
        天引月,
        基礎年金番号,
        年金コード,
        本基礎年金番号,
        本年金コード,
        仮基礎年金番号,
        通知内容コード,
        仮年金コード;
    }

    /**
     * 主キーで年金特徴回付情報（介護継承）を取得します。
     *
     * @param 業務コード GyomuCode
     * @param 処理年度 FlexibleYear
     * @param 通知内容コード RString
     * @param 処理対象年月 FlexibleYearMonth
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 構成市町村コード RString
     * @param 連番 int
     * @return UeT0511NenkinTokuchoKaifuJohoEntity
     * @throws NullPointerException 引数のいずれかがnullの場合
     */
    @Transaction
    public UeT0511NenkinTokuchoKaifuJohoEntity selectByKey(
            GyomuCode 業務コード,
            FlexibleYear 処理年度,
            RString 通知内容コード,
            FlexibleYearMonth 処理対象年月,
            RString 基礎年金番号,
            RString 年金コード,
            RString 構成市町村コード,
            int 連番) throws NullPointerException {
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(通知内容コード, UrSystemErrorMessages.値がnull.getReplacedMessage("通知内容コード"));
        requireNonNull(処理対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理対象年月"));
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        requireNonNull(構成市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村コード"));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(UeT0511NenkinTokuchoKaifuJoho.class).
                where(and(
                                eq(gyomuCode, 業務コード),
                                eq(shoriNendo, 処理年度),
                                eq(tsuchiNaiyoCode, 通知内容コード),
                                eq(shoriTaishoYM, 処理対象年月),
                                eq(kisoNenkinNo, 基礎年金番号),
                                eq(nenkinCode, 年金コード),
                                eq(koseiCityCode, 構成市町村コード),
                                eq(renban, 連番))).
                toObject(UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    /**
     * 年金特徴回付情報（介護継承）を全件返します。
     *
     * @return UeT0511NenkinTokuchoKaifuJohoEntityの{@code list}
     */
    @Transaction
    public List<UeT0511NenkinTokuchoKaifuJohoEntity> selectAll() {
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);

        return accessor.select().
                table(UeT0511NenkinTokuchoKaifuJoho.class).
                toList(UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    /**
     * UeT0511NenkinTokuchoKaifuJohoEntityを登録します。状態によってinsert/update/delete処理に振り分けられます。
     *
     * @param entity entity
     * @return 登録件数
     */
    @Transaction
    @Override
    public int save(UeT0511NenkinTokuchoKaifuJohoEntity entity) {
        requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("年金特徴回付情報（介護継承）エンティティ"));
        // TODO 物理削除であるかは業務ごとに検討してください。
        //return DbAccessors.saveByForDeletePhysical(new DbAccessorNormalType(session), entity);
        return DbAccessors.saveBy(new DbAccessorNormalType(session), entity);
    }

    /**
     * 年金特徴回付情報（介護継承）から、特徴回付情報を取得する。
     *
     * @param 業務コード GyomuCode
     * @param 通知内容コード RString
     * @param 処理年度 FlexibleYear
     * @param 捕捉月 RString
     * @return 年金特徴回付情報エンティティリスト
     */
    @Transaction
    public List<UeT0511NenkinTokuchoKaifuJohoEntity> select特徴回付情報のデータ(
            GyomuCode 業務コード, RString 通知内容コード, FlexibleYear 処理年度, RString 捕捉月) {
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(Constants.業務コード.name()));
        requireNonNull(通知内容コード, UrSystemErrorMessages.値がnull.getReplacedMessage(Constants.通知内容コード.name()));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage(Constants.処理年度.name()));
        requireNonNull(捕捉月, UrSystemErrorMessages.値がnull.getReplacedMessage(Constants.天引月.name()));

        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(UeT0511NenkinTokuchoKaifuJoho.class).
                where(and(eq(gyomuCode, 業務コード),
                                eq(shoriNendo, 処理年度),
                                eq(tsuchiNaiyoCode, 通知内容コード),
                                eq(hosokuTsuki, 捕捉月))).
                toList(UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    /**
     * 年金特徴回付情報（介護継承）から、特徴回付情報を取得する。
     *
     * @param 業務コード GyomuCode
     * @param uet0511entitylist List<UeT0511NenkinTokuchoKaifuJohoEntity>
     * @return 年金特徴回付情報エンティティリスト
     */
    @Transaction
    public List<UeT0511NenkinTokuchoKaifuJohoEntity> select全件特徴回付情報のデータ(
            GyomuCode 業務コード, List<UeT0511NenkinTokuchoKaifuJohoEntity> uet0511entitylist) {
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage(Constants.業務コード.name()));
        if (uet0511entitylist == null || uet0511entitylist.isEmpty()) {
            return new ArrayList();
        }
        ITrueFalseCriteria itruefalsecriteri = eq(gyomuCode, 業務コード);
        for (UeT0511NenkinTokuchoKaifuJohoEntity entity : uet0511entitylist) {
            ITrueFalseCriteria itruefalsecriteriatemp = and(eq(shoriNendo, entity.getShoriNendo()),
                    eq(tsuchiNaiyoCode, entity.getTsuchiNaiyoCode()), eq(hosokuTsuki, entity.getHosokuTsuki()));
            itruefalsecriteri = or(itruefalsecriteri, itruefalsecriteriatemp);
        }
        DbAccessorNormalType accessor = new DbAccessorNormalType(session);
        return accessor.select().
                table(UeT0511NenkinTokuchoKaifuJoho.class).
                where(itruefalsecriteri).
                toList(UeT0511NenkinTokuchoKaifuJohoEntity.class);
    }

    private void entityAddList(List<UeT0511NenkinTokuchoKaifuJohoEntity> list,
            List<UeT0511NenkinTokuchoKaifuJohoEntity> addList) {
        if (!(list.equals(Collections.EMPTY_LIST))) {
            addList.addAll(list);
        }
    }

}
