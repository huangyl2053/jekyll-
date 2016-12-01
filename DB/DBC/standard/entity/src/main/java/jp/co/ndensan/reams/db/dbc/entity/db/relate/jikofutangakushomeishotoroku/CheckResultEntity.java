/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.relate.jikofutangakushomeishotoroku;

import java.io.Serializable;

/**
 * 事業分自己負担額証明書登録（単）のEntityクラスです。
 *
 * @reamsid_L DBC-4820-010 guoll
 */
@lombok.Getter
@lombok.Setter
@SuppressWarnings("PMD.UnusedPrivateField")
public class CheckResultEntity implements Serializable {

    private Boolean is受給者;
    private Boolean is総合事業対象者;
}
