/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.service.core.ninteichosahyo.ninteichosahyotokkijiko;

import java.util.ArrayList;
import java.util.List;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosahyo.ninteichosahyotokkijiko.NinteichosahyoTokkijiko;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.persistence.db.basic.DbT5205NinteichosahyoTokkijikoDac;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;
import jp.co.ndensan.reams.uz.uza.util.di.Transaction;

/**
 * 認定調査票（特記情報）を管理するクラスです。
 *
 * @reamsid_L DBE-9999-011 sunhaidi
 */
public class NinteichosahyoTokkijikoManager {

    private final DbT5205NinteichosahyoTokkijikoDac dac;

    /**
     * コンストラクタです。
     */
    public NinteichosahyoTokkijikoManager() {
        dac = InstanceProvider.create(DbT5205NinteichosahyoTokkijikoDac.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param dac {@link DbT5205NinteichosahyoTokkijikoDac}
     */
    NinteichosahyoTokkijikoManager(DbT5205NinteichosahyoTokkijikoDac dac) {
        this.dac = dac;
    }

    /**
     * 認定調査票（特記情報）{@link NinteichosahyoTokkijiko}を保存します。
     *
     * @param 認定調査票_特記情報 {@link NinteichosahyoTokkijiko}
     * @return 更新件数 更新結果の件数を返します。
     */
    @Transaction
    public boolean save認定調査票_特記情報(NinteichosahyoTokkijiko 認定調査票_特記情報) {
        requireNonNull(認定調査票_特記情報, UrSystemErrorMessages.値がnull.getReplacedMessage("認定調査票（特記情報）"));
        if (!認定調査票_特記情報.hasChanged()) {
            return false;
        }
        return 1 == dac.save(認定調査票_特記情報.toEntity());
    }

    /**
     * 認定調査票（特記情報）{@link NinteichosahyoTokkijiko}を取得します。
     *
     * @param shinseishoKanriNo ShinseishoKanriNo
     * @param ninteichosaRirekiNo ninteichosaRirekiNo
     * @return List<NinteichosahyoTokkijiko>
     */
    @Transaction
    public List<NinteichosahyoTokkijiko> get認定調査票_特記情報(
            ShinseishoKanriNo shinseishoKanriNo,
            int ninteichosaRirekiNo) {
        List<DbT5205NinteichosahyoTokkijikoEntity> resultList
                = dac.selectBy申請書管理番号And認定調査依頼履歴番号(shinseishoKanriNo, ninteichosaRirekiNo);

        List<NinteichosahyoTokkijiko> returnList = new ArrayList<>();
        for (int i = 0; i < resultList.size(); i++) {
            NinteichosahyoTokkijiko tokkijiko = new NinteichosahyoTokkijiko(resultList.get(i));
            returnList.add(tokkijiko);

        }
        return returnList;
    }

    /**
     * 認定調査票（特記情報）{@link NinteichosahyoTokkijiko}を取得します(ByKey)。
     *
     * @param 申請書管理番号 申請書管理番号
     * @param 認定調査依頼履歴番号 認定調査依頼履歴番号
     * @param 認定調査特記事項番号 認定調査特記事項番号
     * @param 認定調査特記事項連番 認定調査特記事項連番
     * @param 特記事項テキスト_イメージ区分 特記事項テキスト_イメージ区分
     * @param 原本マスク区分 原本マスク区分
     * @return NinteichosahyoTokkijiko
     */
    @Transaction
    public NinteichosahyoTokkijiko get認定調査票_特記情報ByKey(
            ShinseishoKanriNo 申請書管理番号,
            int 認定調査依頼履歴番号,
            RString 認定調査特記事項番号,
            int 認定調査特記事項連番,
            RString 特記事項テキスト_イメージ区分,
            Code 原本マスク区分) {

        DbT5205NinteichosahyoTokkijikoEntity entiy = dac.selectByKey(申請書管理番号,
                認定調査依頼履歴番号,
                認定調査特記事項番号,
                認定調査特記事項連番,
                特記事項テキスト_イメージ区分,
                原本マスク区分);
        if (entiy == null) {
            return null;
        } else {
            return new NinteichosahyoTokkijiko(entiy);
        }
    }
}
