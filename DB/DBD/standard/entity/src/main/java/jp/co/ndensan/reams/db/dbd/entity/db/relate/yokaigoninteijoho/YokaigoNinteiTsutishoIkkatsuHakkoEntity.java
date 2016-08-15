/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.db.relate.yokaigoninteijoho;

import java.io.Serializable;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;

/**
 * 要介護認定通知書一括発行Entityのクラスです。
 *
 * @reamsid_L DBD-1430-010 lit
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class YokaigoNinteiTsutishoIkkatsuHakkoEntity implements Cloneable, Serializable {

    private DbT7022ShoriDateKanriEntity entity;
}
