/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshoirairirekiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoirairirekiichiran.IkenshoirairirekiIchiranEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.IkenshoSakuseiKaisuKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.NinteiShinseiShinseijiKubunCode;
import jp.co.ndensan.reams.uz.uza.biz.AtenaJusho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医意見書作成依頼(手動)_主治医意見書依頼該当者履歴一覧のビジネスクラスです。
 *
 * @reamsid_L DBE-1590-030 zuotao
 */
public class IkenshoirairirekiIchiran {

    private final IkenshoirairirekiIchiranEntity entity;

    /**
     * コンストラクタです。
     *
     * @param entity 主治医意見書依頼該当者履歴情報
     */
    public IkenshoirairirekiIchiran(IkenshoirairirekiIchiranEntity entity) {
        this.entity = entity;
    }

    /**
     * 直近区分を取得します。
     *
     * @return 直近区分
     */
    public RString get直近区分() {
        return entity.getChokkinKubun();
    }

    /**
     * 被保険者番号を取得します。
     *
     * @return 被保険者番号
     */
    public HihokenshaNo get被保険者番号() {
        return entity.getHihokenshaNo();
    }

    /**
     * 被保険者氏名カナを取得します。
     *
     * @return 被保険者氏名カナ
     */
    public AtenaKanaMeisho get被保険者氏名カナ() {
        return entity.getHihokenshaKana();
    }

    /**
     * 被保険者氏名を取得します。
     *
     * @return 被保険者氏名
     */
    public AtenaKanaMeisho get被保険者氏名() {
        return entity.getHihokenshaName();
    }

    /**
     * 住所を取得します。
     *
     * @return 住所
     */
    public AtenaJusho get住所() {
        return entity.getJusho();
    }

    /**
     * 医療機関名称を取得します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }

    /**
     * 主治医氏名を取得します。
     *
     * @return 主治医氏名
     */
    public RString get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 主治医意見書作成依頼年月日を取得します。
     *
     * @return 主治医意見書作成依頼年月日
     */
    public FlexibleDate get主治医意見書作成依頼年月日() {
        return entity.getIkenshoSakuseiIraiYMD();
    }

    /**
     * 認定申請区分を取得します。
     *
     * @return .認定申請区分
     */
    public RString get認定申請区分() {
        if (entity.getNinteiShinseiShinseijiKubunCode() != null && !entity.getNinteiShinseiShinseijiKubunCode().isEmpty()) {
            return NinteiShinseiShinseijiKubunCode.toValue(entity.getNinteiShinseiShinseijiKubunCode().getKey()).get名称();
        }
        return RString.EMPTY;
    }

    /**
     * 継続区分を取得します。
     *
     * @return 継続区分
     */
    public RString get継続区分() {
        if (entity.getIkenshoSakuseiKaisuKubun() != null && !entity.getIkenshoSakuseiKaisuKubun().isEmpty()) {
            return IkenshoSakuseiKaisuKubun.toValue(entity.getIkenshoSakuseiKaisuKubun().getKey()).get名称();
        }
        return RString.EMPTY;
    }
}
