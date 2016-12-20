/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.youkaigoninteikekktesuchi;

import java.io.Serializable;
import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.youkaigoninteikekktesuchi.YouKaiGoNinTeiKekTesuChiRelateEntity;
import jp.co.ndensan.reams.db.dbz.definition.core.seibetsu.Seibetsu;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigojotaikubun.YokaigoJotaiKubun09;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiHoreiCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定結果通知情報ビジネスクラスです。
 *
 * @reamsid_L DBE-0220-010 wangkun
 */
public class YouKaiGoNinTeiKekTesuChi implements Serializable {

    private static final long serialVersionUID = 3085320666262315030L;

    private final YouKaiGoNinTeiKekTesuChiRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * 要介護認定結果通知情報ビジネスの新規作成時に使用します。
     *
     * @param relateEntity 要介護認定結果情報RelateEntityクラスです。
     */
    public YouKaiGoNinTeiKekTesuChi(YouKaiGoNinTeiKekTesuChiRelateEntity relateEntity) {
        requireNonNull(relateEntity, UrSystemErrorMessages.値がnull.getReplacedMessage("要介護認定結果情報RelateEntity"));
        this.entity = relateEntity;
    }

    /**
     * 主治医医療機関コードを返します。
     *
     * @return 主治医医療機関コード
     */
    public RString get主治医医療機関コード() {
        return entity.getShujiiIryokikanCode();
    }

    /**
     * 主治医医療機関名称を返します。
     *
     * @return 主治医医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public RString get郵便番号() {
        return entity.getYubinNo();
    }

    /**
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public RString get電話番号() {
        return entity.getTelNo();
    }

    /**
     * 住所を返します。
     *
     * @return 住所
     */
    public RString get住所() {
        return entity.getJusho();
    }

    /**
     * 主治医コードを返します。
     *
     * @return 主治医コード
     */
    public RString get主治医コード() {
        return entity.getShujiiCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 対象件数を返します。
     *
     * @return 対象件数
     */
    public int get対象件数() {
        return entity.getTaiSyouCount();
    }

    /**
     * 連番を返します。
     *
     * @return 連番
     */
    public RString get連番() {
        return new RString(String.valueOf(entity.getRenNo()));
    }

    /**
     * 被保険者番号を返します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名を返します。
     *
     * @return 被保険者氏名
     */
    public RString get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public RString get性別() {
        return Seibetsu.toValue(entity.getSeibetsu()).get名称();
    }

    /**
     * 生年月日を返します。
     *
     * @return 生年月日
     */
    public RString get生年月日() {
        return entity.getSeinengappiYMD();
    }

    /**
     * 年齢を返します。
     *
     * @return 年齢
     */
    public int get年齢() {
        return entity.getAge();
    }

    /**
     * 申請日を返します。
     *
     * @return 申請日
     */
    public RString get申請日() {
        return entity.getNinteiShinseiYMD();
    }

    /**
     * 申請区分（申請時）を返します。
     *
     * @return 申請区分_申請時
     */
    public RString get申請区分_申請時() {
        return NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCod()).get名称();
    }

    /**
     * 申請区分（法令）を返します。
     *
     * @return 申請区分_法令
     */
    public RString get申請区分_法令() {
        NinteiShinseiHoreiCode code = NinteiShinseiHoreiCode.toValue(entity.getNinteiShinseiHoreiKubunCode());
        return code != null ? code.get名称() : RString.EMPTY;

    }

    /**
     * 二次判定結果を返します。
     *
     * @return 二次判定結果
     */
    public RString get二次判定結果() {
        return YokaigoJotaiKubun09.toValue(entity.getNijiHanteiYokaigoJotaiKubunCod()).get名称();
    }

    /**
     * 有効期間を返します。
     *
     * @return 有効期間
     */
    public RString get有効期間() {
        return entity.getNijiHanteiNinteiYukoKikan();
    }

    /**
     * 有効期間開始を返します。
     *
     * @return 有効期間開始
     */
    public RString get有効期間開始() {
        return entity.getNijiHanteiNinteiYukoKaishiYMD();
    }

    /**
     * 有効期間終了を返します。
     *
     * @return 有効期間終了
     */
    public RString get有効期間終了() {
        return entity.getNijiHanteiNinteiYukoShuryoYMD();
    }

    /**
     * 二次判定日を返します。
     *
     * @return 二次判定日
     */
    public RString get二次判定日() {
        return entity.getNijiHanteiYMD();
    }

    /**
     * 認定状況提供日を返します。
     *
     * @return 認定状況提供日
     */
    public RString get認定状況提供日() {
        return entity.getNinteiJohoTeikyoYMD();
    }

    /**
     * 申請書管理番号を返します。
     *
     * @return 申請書管理番号
     */
    public RString get申請書管理番号() {
        return entity.getShinseishoKanriNo();
    }

    /**
     * 市町村コードを取得します。
     *
     * @return 市町村コード
     */
    public RString get市町村コード() {
        return entity.getShichosonCode();
    }
}
