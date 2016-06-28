/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.service.core.basic;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbz.business.core.basic.NenkinTokuchoKaifuJoho;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.UeT0511NenkinTokuchoKaifuJohoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.UeT0511NenkinTokuchoKaifuJohoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 年金特徴回付情報（介護継承）を管理するクラスです。
 */
public class NenkinTokuchoKaifuJohoManager {

    private final UeT0511NenkinTokuchoKaifuJohoDac dac;

    /**
     * コンストラクタです。
     */
    public NenkinTokuchoKaifuJohoManager() {
        dac = InstanceProvider.create(UeT0511NenkinTokuchoKaifuJohoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link UeT0511NenkinTokuchoKaifuJohoDac}
     */
    NenkinTokuchoKaifuJohoManager(UeT0511NenkinTokuchoKaifuJohoDac dac) {
        this.dac = dac;
    }

    /**
     * 主キーに合致する年金特徴回付情報（介護継承）を返します。
     *
     * @param 業務コード GyomuCode
     * @param 処理年度 FlexibleYear
     * @param 通知内容コード RString
     * @param 処理対象年月 FlexibleYearMonth
     * @param 基礎年金番号 RString
     * @param 年金コード RString
     * @param 構成市町村コード RString
     * @param 連番 int
     * @return NenkinTokuchoKaifuJoho
     */
    @Transaction
    public NenkinTokuchoKaifuJoho get年金特徴回付情報_介護継承(
            GyomuCode 業務コード,
            FlexibleYear 処理年度,
            RString 通知内容コード,
            FlexibleYearMonth 処理対象年月,
            RString 基礎年金番号,
            RString 年金コード,
            RString 構成市町村コード,
            int 連番) {
        requireNonNull(業務コード, UrSystemErrorMessages.値がnull.getReplacedMessage("業務コード"));
        requireNonNull(処理年度, UrSystemErrorMessages.値がnull.getReplacedMessage("処理年度"));
        requireNonNull(通知内容コード, UrSystemErrorMessages.値がnull.getReplacedMessage("通知内容コード"));
        requireNonNull(処理対象年月, UrSystemErrorMessages.値がnull.getReplacedMessage("処理対象年月"));
        requireNonNull(基礎年金番号, UrSystemErrorMessages.値がnull.getReplacedMessage("基礎年金番号"));
        requireNonNull(年金コード, UrSystemErrorMessages.値がnull.getReplacedMessage("年金コード"));
        requireNonNull(構成市町村コード, UrSystemErrorMessages.値がnull.getReplacedMessage("構成市町村コード"));

        UeT0511NenkinTokuchoKaifuJohoEntity entity = dac.selectByKey(
                業務コード, 処理年度, 通知内容コード, 処理対象年月, 基礎年金番号, 年金コード, 構成市町村コード, 連番);
        if (entity == null) {
            return null;
        }
        entity.initializeMd5();
        return new NenkinTokuchoKaifuJoho(entity);
    }

    /**
     * 年金特徴回付情報（介護継承）を全件返します。
     *
     * @return NenkinTokuchoKaifuJohoの{@code list}
     */
    @Transaction
    public List<NenkinTokuchoKaifuJoho> get年金特徴回付情報_介護継承一覧() {
        List<NenkinTokuchoKaifuJoho> businessList = new ArrayList<>();

        for (UeT0511NenkinTokuchoKaifuJohoEntity entity : dac.selectAll()) {
            entity.initializeMd5();
            businessList.add(new NenkinTokuchoKaifuJoho(entity));
        }

        return businessList;
    }

    /**
     * 年金特徴回付情報（介護継承）{@link NenkinTokuchoKaifuJoho}を保存します。
     *
     * @param 年金特徴回付情報_介護継承 {@link NenkinTokuchoKaifuJoho}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save年金特徴回付情報_介護継承(NenkinTokuchoKaifuJoho 年金特徴回付情報_介護継承) {
        requireNonNull(年金特徴回付情報_介護継承, UrSystemErrorMessages.値がnull.getReplacedMessage("年金特徴回付情報（介護継承）"));
        if (!年金特徴回付情報_介護継承.hasChanged()) {
            return false;
        }
        return 1 == dac.save(年金特徴回付情報_介護継承.toEntity()
        );
    }
}
