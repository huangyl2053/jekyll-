/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai;

import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinTokkiJikouItiziHanteiProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.HanteiJohoEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 事務局用予備判定記入表情報のBusinessの編集クラスです。
 *
 * @reamsid_L DBE-0150-190 linghuhang
 */
public class JimuYobihanteiKinyuhyoBusiness {

    private static final int INDEX_5 = 5;
    private final HanteiJohoEntity entity;
    private final IinTokkiJikouItiziHanteiProcessParameter paramter;

    /**
     * コンストラクタです。
     *
     * @param entity HanteiJohoEntity
     * @param paramter IinTokkiJikouItiziHanteiProcessParameter
     */
    public JimuYobihanteiKinyuhyoBusiness(
            HanteiJohoEntity entity,
            IinTokkiJikouItiziHanteiProcessParameter paramter) {
        this.entity = entity;
        this.paramter = paramter;
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public RString get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 識別コードは証記載保険者番号（左から5桁）+被保険者番号を設定してください。
     *
     * @return 識別コード
     */
    public RString get識別コード() {
        return entity.getShoKisaiHokenshaNo().substring(0, INDEX_5).concat(entity.getHihokenshaNo());
    }

    /**
     * 氏名を取得します。
     *
     * @return 氏名
     */
    public RString get氏名() {
        if (entity.getHihokenshaName() == null || RString.isNullOrEmpty(entity.getHihokenshaName().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getHihokenshaName().getColumnValue();
    }

    /**
     * 一次判定警告コードを取得します。
     *
     * @return 一次判定警告コード
     */
    public RString get一次判定警告コード() {
        return entity.getIchijiHnateiKeikokuCode();
    }

    /**
     * 保険者を取得します。
     *
     * @return 保険者
     */
    public RString get保険者() {
        return entity.getShichosonMeisho();
    }

    /**
     * 開催年月日を取得します。
     *
     * @return 開催年月日
     */
    public FlexibleDate get開催年月日() {
        return paramter.getShinsakaiKaisaiYoteiYMD();
    }

    /**
     * 開催時を取得します。
     *
     * @return 開催時
     */
    public RString get開催時() {
        return paramter.getShinsakaiKaishiYoteiTime().split(":").get(0);
    }

    /**
     * 開催分を取得します。
     *
     * @return 開催分
     */
    public RString get開催分() {
        return paramter.getShinsakaiKaishiYoteiTime().split(":").get(1);
    }

    /**
     * 合議体名称を取得します。
     *
     * @return 合議体名称
     */
    public RString get合議体名称() {
        return paramter.getGogitaiName();
    }

    /**
     * 審査会開催番号を取得します。
     *
     * @return 審査会開催番号
     */
    public RString get審査会開催番号() {
        return paramter.getShinsakaiKaisaiNo();
    }

    /**
     * 番号を取得します。
     *
     * @return No
     */
    public RString getNo() {
        return new RString(entity.getShinsakaiOrder());
    }

    /**
     * 申請区分を取得します。
     *
     * @return 申請区分
     */
    public RString get申請区分() {
        if (entity.getShinseijiKubunCode() == null || entity.getShinseijiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        return entity.getShinseijiKubunCode().getColumnValue();
    }

    /**
     * 性別を取得します。
     *
     * @return 性別
     */
    public RString get性別() {
        if (entity.getSeibetsu() == null || entity.getSeibetsu().isEmpty()) {
            return RString.EMPTY;
        }
        return entity.getSeibetsu().getColumnValue();
    }

    /**
     * 年齢を取得します。
     *
     * @return 年齢
     */
    public RString get年齢() {
        return new RString(entity.getAge());
    }

    /**
     * 前回二次判定を取得します。
     *
     * @return 前回二次判定
     */
    public RString get前回二次判定() {
        if (entity.getYokaigoJotaiKubunCode() == null || entity.getYokaigoJotaiKubunCode().isEmpty()) {
            return RString.EMPTY;
        }
        return entity.getYokaigoJotaiKubunCode().getColumnValue();
    }

    /**
     * 前回認定有効期間を取得します。
     *
     * @return 前回認定有効期間
     */
    public RString get前回認定有効期間() {
        if (entity.getHanteiNinteiYukoKikan() != 0) {
            return new RString(entity.getHanteiNinteiYukoKikan());
        }
        return RString.EMPTY;
    }

    /**
     * 一次判定を取得します。
     *
     * @return 一次判定
     */
    public RString get一次判定() {
        if (entity.getIchijiHanteiKekkaCode() == null || entity.getIchijiHanteiKekkaCode().isEmpty()) {
            return RString.EMPTY;
        }
        return entity.getIchijiHanteiKekkaCode().getColumnValue();
    }

    /**
     * 二次判定を取得します。
     *
     * @return 二次判定
     */
    public RString get二次判定() {
        return RString.EMPTY;
    }

    /**
     * 状態像を取得します。
     *
     * @return 状態像
     */
    public RString get状態像() {
        return RString.EMPTY;
    }

    /**
     * 認定有効期間を取得します。
     *
     * @return 認定有効期間
     */
    public RString get認定有効期間() {
        return RString.EMPTY;
    }

    /**
     * 特定疾病コードを取得します。
     *
     * @return 特定疾病コード
     */
    public RString get特定疾病コード() {
        if (entity.getNigoTokuteiShippeiCode() == null || RString.isNullOrEmpty(entity.getNigoTokuteiShippeiCode().getColumnValue())) {
            return RString.EMPTY;
        }
        return entity.getNigoTokuteiShippeiCode().getColumnValue();
    }

    /**
     * 特定疾病名称を取得します。
     *
     * @return 特定疾病名称
     */
    public RString get特定疾病名称() {
        if (entity.getNigoTokuteiShippeiCode() == null || entity.getNigoTokuteiShippeiCode().isEmpty()) {
            return RString.EMPTY;
        }
        return entity.getNigoTokuteiShippeiCode().getColumnValue();
    }

    /**
     * 調査員特記事項を取得します。
     *
     * @return 調査員特記事項
     */
    public RString get調査員特記事項() {
        return RString.EMPTY;
    }

    /**
     * 主治医意見書を取得します。
     *
     * @return 主治医意見書
     */
    public RString get主治医意見書() {
        return RString.EMPTY;
    }
}
