/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.basic.shujiijoho;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.db.dbe.entity.basic.shujiijoho.ShujiiMasterRelateEntity;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 主治医情報を管理するクラスです。
 */
public class ShujiiMaster {

    private final ShujiiMasterRelateEntity entity;

    /**
     * コンストラクタです。<br/>
     * DBより取得した{@link ShujiiMasterRelateEntity}より{@link ShujiiJoho}を生成します。
     *
     * @param entity DBより取得した{@link ShujiiMasterRelateEntity}
     */
    public ShujiiMaster(ShujiiMasterRelateEntity entity) {
        this.entity = requireNonNull(entity, UrSystemErrorMessages.値がnull.getReplacedMessage("主治医情報"));
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public LasdecCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * 主治医氏名を返します。
     *
     * @return 主治医氏名
     */
    public AtenaMeisho get主治医氏名() {
        return entity.getShujiiName();
    }

    /**
     * 主治医カナを返します。
     *
     * @return 主治医カナ
     */
    public AtenaKanaMeisho get主治医カナ() {
        return entity.getShujiiKana();
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
     * 診療科名称を返します。
     *
     * @return 診療科名称
     */
    public RString get診療科名称() {
        return entity.getShinryokaName();
    }

    /**
     * 指定医フラグを返します。
     *
     * @return 指定医フラグ
     */
    public boolean is指定医フラグ() {
        return entity.isShiteiiFlag();
    }

    /**
     * 状況フラグを返します。
     *
     * @return 状況フラグ
     */
    public boolean is状況フラグ() {
        return entity.isJokyoFlag();
    }

    /**
     * 郵便番号を返します。
     *
     * @return 郵便番号
     */
    public YubinNo get郵便番号() {
        return entity.getYubinNo();
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
     * 電話番号を返します。
     *
     * @return 電話番号
     */
    public TelNo get電話番号() {
        return entity.getTelNo();
    }

    /**
     * FAX番号を返します。
     *
     * @return FAX番号
     */
    public TelNo getFAX番号() {
        return entity.getFaxNo();
    }

    /**
     * 性別を返します。
     *
     * @return 性別
     */
    public Code get性別() {
        return entity.getSeibetsu();
    }

    /**
     * 市町村名称を返します。
     *
     * @return 市町村名称
     */
    public RString get市町村名称() {
        return entity.getShichosonMeisho();
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
     * 医療機関名称を返します。
     *
     * @return 医療機関名称
     */
    public RString get医療機関名称() {
        return entity.getIryoKikanMeisho();
    }
}
