/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.business.core.ninteishinseishakihoninfo;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shisetsunyushoinfo.ninteishinseishakihoninfo.NinteiShinseishaKihonInfoRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定申請者基本情報のBusinessクラスです。
 *
 * @reamsid_L DBE-3000-190 hezhenzhen
 *
 */
public class NinteiShinseishaKihonInfoBusiness {

    private final NinteiShinseishaKihonInfoRelateEntity relateEntity;

    /**
     * コンストラクタです.
     *
     * @param relateEntity NinteiShinseishaKihonInfoRelateEntity
     */
    public NinteiShinseishaKihonInfoBusiness(NinteiShinseishaKihonInfoRelateEntity relateEntity) {
        this.relateEntity = requireNonNull(relateEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("認定申請者基本情報"));
    }

    /**
     * 申請書管理番号を取得します。
     *
     * @return 申請書管理番号
     */
    public ShinseishoKanriNo get申請書管理番号() {
        return relateEntity.getShinseishoKanriNo();
    }

    /**
     * 証記載保険者番号を取得します。
     *
     * @return 証記載保険者番号
     */
    public RString get証記載保険者番号() {
        return relateEntity.getShoKisaiHokenshaNo();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return relateEntity.getHihokenshaNo();
    }

    /**
     * 被保険者区分コードを取得します。
     *
     * @return 被保険者区分コード
     */
    public RString get被保険者区分コード() {
        return relateEntity.getHihokenshaKubunCode();
    }

    /**
     * 生年月日を取得します。
     *
     * @return 生年月日
     */
    public FlexibleDate get生年月日() {
        return relateEntity.getSeinengappiYMD();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return relateEntity.getAge();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public Code get性別() {
        return relateEntity.getSeibetsu();
    }

    /**
     * 保険者氏名を取得します。
     *
     * @return 保険者氏名
     */
    public AtenaMeisho get被保険者氏名() {
        return relateEntity.getHihokenshaName();
    }

    /**
     * 被保険者氏名カナを取得します。
     *
     * @return 申請書管理番号
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return relateEntity.getHihokenshaKana();
    }

    /**
     * 郵便番号を取得します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return relateEntity.getYubinNo();
    }

    /**
     * 電話番号を取得します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return relateEntity.getTelNo();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return relateEntity.getJusho();
    }

    /**
     * 市町村名称を取得します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return relateEntity.getShichosonMeisho();
    }

    /**
     * 認定申請日を取得します。
     *
     * @return 認定申請日
     */
    public FlexibleDate get認定申請日() {
        return relateEntity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分（申請時）を取得します。
     *
     * @return 申請区分（申請時）
     */
    public Code get申請区分_申請時() {
        return relateEntity.getNinteiShinseiShinseijiKubunCode();
    }

    /**
     * 申請区分（法令時）を取得します。
     *
     * @return 申請区分（法令時）
     */
    public Code get申請区分_法令時() {
        return relateEntity.getNinteiShinseiHoreiKubunCode();
    }
}
