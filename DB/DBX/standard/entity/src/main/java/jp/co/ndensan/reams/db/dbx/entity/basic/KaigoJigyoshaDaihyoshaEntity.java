/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbx.entity.basic;

import static java.util.Objects.requireNonNull;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;
import jp.co.ndensan.reams.uz.uza.util.db.OnRshareSchema;

/**
 * 介護事業者代表者マスタの内容を持つエンティティです。
 *
 * @author n2818 西澤 貴幸
 * @jpName 介護事業者代表者エンティティ
 * @bizDomain 介護
 * @category 介護
 * @subCategory 介護事業者代表者
 * @mainClass
 * @reference
 * @deprecated {@link UrT0520KaigoJigyoshaDaihyoshaEntity}を使用してください。
 */
@OnRshareSchema
public class KaigoJigyoshaDaihyoshaEntity implements IDbAccessable {

    /**
     * 事業者番号
     */
    private RString jigyoshaBango;
    /**
     * 有効開始年月日
     */
    private RDate yukoKaishiYMD;
    /**
     * 代表者名
     */
    private RString daihyoshaMei;
    /**
     * 代表者名カナ
     */
    private RString daihyoshaMeiKana;
    /**
     * 代表者郵便番号
     */
    private RString daihyoshaYubinBango;
    /**
     * 代表者住所
     */
    private RString daihyoshaJusho;
    /**
     * 代表者住所カナ
     */
    private RString daihyoshaJushoKana;
    /**
     * 代表者役職名
     */
    private RString daihyoshaYakushokuMei;
    /**
     * 代表者電話番号
     */
    private RString daihyoshaDenwaBango;
    /**
     * 代表者内線番号
     */
    private RString daihyoshaNaisenBango;
    /**
     * 代表者ＦＡＸ番号
     */
    private RString daihyoshaFAXBango;
    /**
     * 開設日
     */
    private RDate kaisetsuYMD;
    /**
     * 閉設日
     */
    private RDate heisetsuYMD;
    /**
     * 開設者名称
     */
    private RString kaisetsushaMeisho;
    /**
     * 開設者名称カナ
     */
    private RString kaisetsushaMeishoKana;
    /**
     * 開設者郵便番号
     */
    private RString kaisetsushaYubinBango;
    /**
     * 開設者住所
     */
    private RString kaisetsushaJusho;
    /**
     * 開設者住所カナ
     */
    private RString kaisetsushaJushoKana;
    /**
     * 開設者電話番号
     */
    private RString kaisetsushaDenwaBango;
    /**
     * 開設者ＦＡＸ番号
     */
    private RString kaisetsushaFAXBango;

    /**
     * 介護事業者代表者エンティティのコンストラクタです。
     *
     * @param jigyoshaBango 事業者番号
     * @param yukoKaishiYMD 有効開始年月日
     * @param daihyoshaMei 代表者名
     * @param daihyoshaMeiKana 代表者名カナ
     * @param daihyoshaYubinBango 代表者郵便番号
     * @param daihyoshaJusho 代表者住所
     * @param daihyoshaJushoKana 代表者住所カナ
     * @param daihyoshaYakushokuMei 代表者役職名
     * @param daihyoshaDenwaBango 代表者電話番号
     * @param daihyoshaNaisenBango 代表者内線番号
     * @param daihyoshaFAXBango 代表者ＦＡＸ番号
     * @param kaisetsuYMD 開設日
     * @param heisetsuYMD 閉設日
     * @param kaisetsushaMeisho 開設者名称
     * @param kaisetsushaMeishoKana 開設者名称カナ
     * @param kaisetsushaYubinBango 開設者郵便番号
     * @param kaisetsushaJusho 開設者住所
     * @param kaisetsushaJushoKana 開設者住所カナ
     * @param kaisetsushaDenwaBango 開設者電話番号
     * @param kaisetsushaFAXBango 開設者ＦＡＸ番号
     */
    public KaigoJigyoshaDaihyoshaEntity(RString jigyoshaBango, RDate yukoKaishiYMD, RString daihyoshaMei,
            RString daihyoshaMeiKana, RString daihyoshaYubinBango, RString daihyoshaJusho,
            RString daihyoshaJushoKana, RString daihyoshaYakushokuMei, RString daihyoshaDenwaBango,
            RString daihyoshaNaisenBango, RString daihyoshaFAXBango, RDate kaisetsuYMD,
            RDate heisetsuYMD, RString kaisetsushaMeisho, RString kaisetsushaMeishoKana,
            RString kaisetsushaYubinBango, RString kaisetsushaJusho, RString kaisetsushaJushoKana,
            RString kaisetsushaDenwaBango, RString kaisetsushaFAXBango) {
        this.jigyoshaBango = requireNonNull(jigyoshaBango, UrSystemErrorMessages.値がnull.getReplacedMessage("jigyoshaBango"));
        this.yukoKaishiYMD = requireNonNull(yukoKaishiYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("yukoKaishiYMD"));
        this.daihyoshaMei = requireNonNull(daihyoshaMei, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaMei"));
        this.daihyoshaMeiKana = requireNonNull(daihyoshaMeiKana, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaMeiKana"));
        this.daihyoshaYubinBango = requireNonNull(daihyoshaYubinBango, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaYubinBango"));
        this.daihyoshaJusho = requireNonNull(daihyoshaJusho, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaJusho"));
        this.daihyoshaJushoKana = requireNonNull(daihyoshaJushoKana, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaJushoKana"));
        this.daihyoshaYakushokuMei = requireNonNull(daihyoshaYakushokuMei, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaYakushokumei"));
        this.daihyoshaDenwaBango = requireNonNull(daihyoshaDenwaBango, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaDenwaBango"));
        this.daihyoshaNaisenBango = requireNonNull(daihyoshaNaisenBango, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaNaisenBango"));
        this.daihyoshaFAXBango = requireNonNull(daihyoshaFAXBango, UrSystemErrorMessages.値がnull.getReplacedMessage("daihyoshaFAXBango"));
        this.kaisetsuYMD = requireNonNull(kaisetsuYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsuYMD"));
        this.heisetsuYMD = requireNonNull(heisetsuYMD, UrSystemErrorMessages.値がnull.getReplacedMessage("heisetsuYMD"));
        this.kaisetsushaMeisho = requireNonNull(kaisetsushaMeisho, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaMeisho"));
        this.kaisetsushaMeishoKana = requireNonNull(kaisetsushaMeishoKana, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaMeishoKana"));
        this.kaisetsushaYubinBango = requireNonNull(kaisetsushaYubinBango, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaYubinBango"));
        this.kaisetsushaJusho = requireNonNull(kaisetsushaJusho, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaJusho"));
        this.kaisetsushaJushoKana = requireNonNull(kaisetsushaJushoKana, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaJushoKana"));
        this.kaisetsushaDenwaBango = requireNonNull(kaisetsushaDenwaBango, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaDenwaBango"));
        this.kaisetsushaFAXBango = requireNonNull(kaisetsushaFAXBango, UrSystemErrorMessages.値がnull.getReplacedMessage("kaisetsushaFAXBango"));
    }

    /**
     * 事業者番号を返します。
     *
     * @return jigyoshaBango
     */
    public RString get事業者番号() {
        return jigyoshaBango;
    }

    /**
     * 有効開始年月日を返します。
     *
     * @return yukoKaishiYMD
     */
    public RDate get有効開始年月日() {
        return yukoKaishiYMD;
    }

    /**
     * 代表者名を返します。
     *
     * @return daihyoshaMei
     */
    public RString get代表者名() {
        return daihyoshaMei;
    }

    /**
     * 代表者名カナを返します。
     *
     * @return daihyoshaMeiKana
     */
    public RString get代表者名カナ() {
        return daihyoshaMeiKana;
    }

    /**
     * 代表者郵便番号を返します。
     *
     * @return daihyoshaYubinBango
     */
    public RString get代表者郵便番号() {
        return daihyoshaYubinBango;
    }

    /**
     * 代表者住所を返します。
     *
     * @return daihyoshaJusho
     */
    public RString get代表者住所() {
        return daihyoshaJusho;
    }

    /**
     * 代表者住所カナを返します。
     *
     * @return daihyoshaJushoKana
     */
    public RString get代表者住所カナ() {
        return daihyoshaJushoKana;
    }

    /**
     * 代表者役職名を返します。
     *
     * @return daihyoshaYakusyokuMei
     */
    public RString get代表者役職名() {
        return daihyoshaYakushokuMei;
    }

    /**
     * 代表者電話番号を返します。
     *
     * @return daihyoshaDenwabango
     */
    public RString get代表者電話番号() {
        return daihyoshaDenwaBango;
    }

    /**
     * 代表者内線番号を返します。
     *
     * @return daihyoshaNaisenBango
     */
    public RString get代表者内線番号() {
        return daihyoshaNaisenBango;
    }

    /**
     * 代表者ＦＡＸ番号を返します。
     *
     * @return daihyoshaFAXBango
     */
    public RString get代表者ＦＡＸ番号() {
        return daihyoshaFAXBango;
    }

    /**
     * 開設日を返します。
     *
     * @return kaisetsuYMD
     */
    public RDate get開設日() {
        return kaisetsuYMD;
    }

    /**
     * 閉設日を返します。
     *
     * @return heisetsuYMD
     */
    public RDate get閉設日() {
        return heisetsuYMD;
    }

    /**
     * 開設者名称を返します。
     *
     * @return kaisetsushaMeisho
     */
    public RString get開設者名称() {
        return kaisetsushaMeisho;
    }

    /**
     * 開設者名称カナを返します。
     *
     * @return kaisetsushaMeishoKana
     */
    public RString get開設者名称カナ() {
        return kaisetsushaMeishoKana;
    }

    /**
     * 開設者郵便番号を返します。
     *
     * @return kaisetsushaYubinBango
     */
    public RString get開設者郵便番号() {
        return kaisetsushaYubinBango;
    }

    /**
     * 開設者住所を返します。
     *
     * @return kaisetsushaJusho
     */
    public RString get開設者住所() {
        return kaisetsushaJusho;
    }

    /**
     * 開設者住所カナを返します。
     *
     * @return kaisetsushaJushoKana
     */
    public RString get開設者住所カナ() {
        return kaisetsushaJushoKana;
    }

    /**
     * 開設者電話番号を返します。
     *
     * @return kaisetsushaDenwaBango
     */
    public RString get開設者電話番号() {
        return kaisetsushaDenwaBango;
    }

    /**
     * 開設者ＦＡＸ番号を返します。
     *
     * @return kaisetsushaFAXBango
     */
    public RString get開設者ＦＡＸ番号() {
        return kaisetsushaFAXBango;
    }
}
